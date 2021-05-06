package com.example.puppynotificationcenter.repositories;

import com.example.puppynotificationcenter.models.DogNotification;

public interface DogNotificationRepository {
    int add(DogNotification dogNotification);
    DogNotification get(String phoneNumber, String email);
    int update(DogNotification dogNotification);
    int remove(String phoneNumber, String email);
}
