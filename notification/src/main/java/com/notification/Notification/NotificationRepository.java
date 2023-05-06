package com.notification.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<notification, Long> {
 
    List<notification> findBytype(notifType type);

}
