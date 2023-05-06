package com.pfe.Password;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/password")
@RequiredArgsConstructor
public class PasswordController {
    

    final private passwordService service;

    @PostMapping("/changePassword/{id}")
    public ResponseEntity<?> changePassword(@RequestBody changePassword request,@PathVariable int id) {
        return ResponseEntity.ok(service.changePassword(request,id));
    }
}
