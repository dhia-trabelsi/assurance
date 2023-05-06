package com.pfe.token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.user.User;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    
    List<Token> findValidAllTokenByUser(User user);
    Optional<Token> findByToken(String token);
}
