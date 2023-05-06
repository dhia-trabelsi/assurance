package com.pfe.Password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.user.User;
import com.pfe.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class passwordService {
    

    private final UserRepository repository;

    public String changePassword(@RequestBody changePassword request, int userId) {
        
        User user = repository.findById(userId).orElseThrow();

        
         String encodedPassword = user.getPassword();

         PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if (!passwordEncoder.matches(request.getOldPassword(), encodedPassword)) {
        return "error";
    }

    // encode and store the new password in the database
    user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);

    return "password changed";
    }

    
}
