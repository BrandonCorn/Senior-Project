package com.example.puppynotificationcenter.dao;

import com.example.puppynotificationcenter.models.DogNotification;
import org.springframework.stereotype.Component;

public interface DogNotificationDao {
    int create(DogNotification dogNotification);
    DogNotification retrieve(String phoneNumber, String email);
    int delete(String phoneNumber, String email);
    int update(DogNotification notification);
}