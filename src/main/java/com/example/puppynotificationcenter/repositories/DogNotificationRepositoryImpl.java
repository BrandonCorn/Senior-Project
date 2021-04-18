package com.example.puppynotificationcenter.repositories;

import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.dao.DogNotificationDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DogNotificationRepositoryImpl implements DogNotificationRepository {
    @Autowired
    private DogNotificationDaoImpl dogNotifDao;

    public DogNotificationRepositoryImpl(){}

    @Override
    public int add(DogNotification dogNotification) {
        return dogNotifDao.create(dogNotification);
    }

    @Override
    public DogNotification get(String phoneNumber, String email) {
        DogNotification dogNotification = dogNotifDao.retrieve(phoneNumber, email);
        return dogNotification;
    }

    @Override
    public int update(DogNotification dogNotification) {
        return dogNotifDao.update(dogNotification);
    }

    @Override
    public int remove(DogNotification dogNotification) {
        return dogNotifDao.delete(dogNotification);
    }
}
