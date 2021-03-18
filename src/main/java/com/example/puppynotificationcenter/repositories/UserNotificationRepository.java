package com.example.puppynotificationcenter.repositories;

import com.example.puppynotificationcenter.models.UserNotification;
import org.springframework.data.repository.CrudRepository;

public interface UserNotificationRepository {
    void add(UserNotification userNotification);
    UserNotification get(String phoneNumber, String email);
    void update(UserNotification userNotification);
    void remove(UserNotification userNotification);
}
