package com.pfe.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfe.auth.Util.EmailRequest;
import com.pfe.auth.Util.EmailSender;
import com.pfe.auth.Util.NotifSender;
import com.pfe.config.JwtService;
import com.pfe.token.Token;
import com.pfe.token.TokenRepository;
import com.pfe.token.TokenType;
import com.pfe.user.Child;
import com.pfe.user.ChildRepository;
import com.pfe.user.ChldDto;
import com.pfe.user.Role;
import com.pfe.user.User;
import com.pfe.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository repository;
  private final ChildRepository childRepository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final NotifSender notifSender;
  private final EmailSender emailSender;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .phone(request.getPhone())
        .address(request.getAddress())
        .age(request.getAge())
        .sexe(request.getSexe())
        .cin(request.getCin())
        .coinjoint(request.getCoinjoint())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.ROLE_USER)
        .societeId(request.getSocieteId())
        .build();

    System.out.println("Request children: " + request.getChildren());

    if (request.getChildren() != null) {
      for (ChldDto childDto : request.getChildren()) {
        Child child = Child.builder()
            .name(childDto.getName())
            .birthDate(childDto.getBirthDate())
            .build();
        user.getChildren().add(child);
      }
    }
    if (request.getChildren() != null) {
      childRepository.saveAll(user.getChildren());
    }
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);

    String message = "nouveau adherent : " + user.getFirstname() + " " + user.getLastname() + " a rejoint la societe "
        + user.getSocieteId();
    notifSender.sendNotif(message, "NEW_ADHERENT");

    EmailRequest emailRequest = new EmailRequest();

    emailRequest.setTo(user.getEmail());
    emailRequest.setSubject("Bienvenue chez nous");
    String body = "Bonjour " + user.getFirstname() + " " + user.getLastname()
    + ",\n\nNous vous souhaitons la bienvenue chez nous. votre Email : " + user.getEmail() +" votre mot de passe : " + request.getPassword() + "\n\nCordialement,\n\nL'équipe de gestion de la société "
    + user.getSocieteId();
    emailRequest.setText(body);

    emailSender.sendEmail(emailRequest);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse registerAdmins(RegisterRequest request) {
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .phone(request.getPhone())
        .address(request.getAddress())
        .age(request.getAge())
        .sexe(request.getSexe())
        .cin(request.getCin())
        .coinjoint(request.getCoinjoint())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.ROLE_ADMIN)
        .build();

    if (request.getChildren() != null) {
      System.out.println("children not null");
      for (ChldDto childDto : request.getChildren()) {
        Child child = Child.builder()
            .name(childDto.getName())
            .birthDate(childDto.getBirthDate())
            .build();
        user.getChildren().add(child);
      }
    }
    if (request.getChildren() != null) {
      childRepository.saveAll(user.getChildren());
    }
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);

    String message = "nouveau admin : " + user.getFirstname() + " " + user.getLastname() + " a rejoint la societe "
        + user.getSocieteId();




    notifSender.sendNotif(message, "NEW_ADMIN");

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()));
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findValidAllTokenByUser(user);
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
