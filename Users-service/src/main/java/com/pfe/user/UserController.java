package com.pfe.user;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.auth.AuthenticationResponse;
import com.pfe.auth.AuthenticationService;
import com.pfe.auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService service;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/registerAdmins")
    public ResponseEntity<AuthenticationResponse> registerAdmins(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.registerAdmins(request));
    }

    @GetMapping("/role")
    public ResponseEntity<?> getAllUsersWithRole(@RequestParam Role role) {

        if (userService.getAllUsersWithRole(role) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getAllUsersWithRole(role));
        }
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {

        if (userService.getUserByEmail(email) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        if (userService.getAllUsers() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserByid(@PathVariable Integer id) {

        if (userService.getUserById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getUserById(id));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
        if (userService.updateUser(user, id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.updateUser(user, id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/BySocieteIDAndRole")
    public ResponseEntity<?> getAllUsersBySocieteIDAndRole(@RequestParam int societeId, @RequestParam Role role) {
        if (userService.getUsersBySocieteID(societeId, role) == null) {
            return ResponseEntity.notFound().build();
        } else {
            System.out.println(userService.getUsersBySocieteID(societeId, role));
            return ResponseEntity.ok(userService.getUsersBySocieteID(societeId, role));
        }
    }

    @GetMapping("/getUserByRole")
    public ResponseEntity<?> getUserByRole(@RequestParam String email) {
        if (userService.getUserByRole(email) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getUserByRole(email));
        }
    }

    @GetMapping("/authuser")
    public ResponseEntity<?> getAuthUser() {
        if (userService.getAuthenticatedUser() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userService.getAuthenticatedUser());
        }
    }

    // @PostMapping("/image/{id}")
    // public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Integer id) throws IOException {
    //     return ResponseEntity.ok(userService.uploadeImage(file,id));
    // }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Integer id) throws IOException {
        return ResponseEntity.ok(userService.uploadImageToFileSystem(file, id));
    }
      

}
