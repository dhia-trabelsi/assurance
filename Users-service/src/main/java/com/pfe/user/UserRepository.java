package com.pfe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    List<User> findAllByRole(Role role);
    List<User> findAllBySocieteIdAndRole(Integer societeId, Role role);
}