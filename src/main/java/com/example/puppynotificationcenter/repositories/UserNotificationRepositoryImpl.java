package com.example.puppynotificationcenter.repositories;

import com.example.puppynotificationcenter.models.UserNotification;
import com.example.puppynotificationcenter.services.UserNotificationDaoImpl;

public class UserNotificationRepositoryImpl implements UserNotificationRepository {
    private UserNotificationDaoImpl userNotifDao;
    @Override
    public void add(UserNotification userNotification) {
        userNotifDao.create(userNotification);
    }

    @Override
    public UserNotification get(String phoneNumber, String email) {
        UserNotification userNotification = userNotifDao.retrieve(phoneNumber, email);
        return userNotification;
    }

    @Override
    public void update(UserNotification userNotification) {
        userNotifDao.update(userNotification);
    }

    @Override
    public void remove(UserNotification userNotification) {
        userNotifDao.delete(userNotification);
    }
}
