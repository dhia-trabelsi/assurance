package com.notification.Notification;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
    

    private final NotificationRepository notifRepository;


    public notification save(notification notif) {
        return notifRepository.save(notif);
    }

    public notification findById(Long id) {
        return notifRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        notifRepository.deleteById(id);
    }

    public void deleteAll() {
        notifRepository.deleteAll();
    }

    public List<notification> getByType(String type) {
        return notifRepository.findBytype(notifType.valueOf(type));
    }

    public List<notification> getAll() {
        return notifRepository.findAll();
    }
}
