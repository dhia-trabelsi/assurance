package com.notification.Notification;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    
    private final NotificationService notifService;

    
    @PostMapping
    public ResponseEntity<notification> save(@RequestBody notification notif) {
        return ResponseEntity.ok(notifService.save(notif));
    }

    @GetMapping("/{id}")
    public ResponseEntity<notification> findById(@PathVariable Long id) {
        return ResponseEntity.ok(notifService.findById(id));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<notification>> getAll() {
        return ResponseEntity.ok(notifService.getAll());
    }

    @GetMapping
    public ResponseEntity<List<notification>> getByType(@RequestParam String type) {
        return ResponseEntity.ok(notifService.getByType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notifService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        notifService.deleteAll();
        return ResponseEntity.ok().build();
    }


}
