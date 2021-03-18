package com.example.puppynotificationcenter.services;

import com.example.puppynotificationcenter.models.UserNotification;

public interface UserNotificationDao {
    void create(UserNotification userNotification);
    UserNotification retrieve(String phoneNumber, String email);
    void delete(UserNotification userNotification);
    void update(UserNotification userNotification);
}
