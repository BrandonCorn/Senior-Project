package com.example.puppynotificationcenter.repositories;

import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.dao.DogNotificationDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return dogNotifDao.retrieve(phoneNumber, email);
    }

    @Override
    public int update(DogNotification dogNotification) {
        return dogNotifDao.update(dogNotification);
    }

    @Override
    public int remove(String phoneNumber, String email) {
        return dogNotifDao.delete(phoneNumber, email);
    }

    public List<String> getNotificationsSubscribers() {
        return dogNotifDao.retrieveNotificationSubscribers();
    }
}
