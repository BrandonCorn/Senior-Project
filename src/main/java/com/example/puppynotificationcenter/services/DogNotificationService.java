package com.example.puppynotificationcenter.services;

import com.example.puppynotificationcenter.controllers.schemas.AppointmentReminderBody;
import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.repositories.DogNotificationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DogNotificationService {
    @Autowired
    private DogNotificationRepositoryImpl dogNotificationRepositoryImpl;
    @Autowired
    private TwilioService twilioService;


    public DogNotification createDogNotificationRecord(DogNotification notification) {
        if (notification.getSubbedMarketing() != false){
            HashMap<String, String> subscriptionInfo = twilioService.setupSubscription(notification.getPhoneNumber());
            for (Map.Entry<String, String> set : subscriptionInfo.entrySet()) {
                notification.setBindingSid(set.getKey());
                notification.setIdentitySid(set.getValue());
            }
        }
        else{
            notification.setBindingSid("");
            notification.setIdentitySid("");
        }
        dogNotificationRepositoryImpl.add(notification);
        return notification;
    }

    public boolean deleteDogNotificationRecord(String phoneNumber, String email) {
        DogNotification notification = dogNotificationRepositoryImpl.get(phoneNumber, email);
        if (notification.getBindingSid().length() > 1) {
            twilioService.deleteSubscription(notification.getBindingSid());
        }
        dogNotificationRepositoryImpl.remove(phoneNumber, email);
        return true;
    }


    public DogNotification createDogNotificationSubscription(String phoneNumber, String email) {
        DogNotification notification = dogNotificationRepositoryImpl.get(phoneNumber, email);
        if (notification.getBindingSid().length() > 0) throw new RuntimeException("Subscription already exists");
        HashMap<String, String> subscriptionInfo = twilioService.setupSubscription(notification.getPhoneNumber());
        for (Map.Entry<String, String> set : subscriptionInfo.entrySet()) {
            notification.setBindingSid(set.getKey());
            notification.setIdentitySid(set.getValue());
        }
        notification.setSubbedMarketing(true);
        dogNotificationRepositoryImpl.update(notification);
        return notification;
    }

    public boolean deleteDogNotificationSubscription(String phoneNumber, String email) {
        DogNotification notification = dogNotificationRepositoryImpl.get(phoneNumber, email);
        twilioService.deleteSubscription(notification.getBindingSid());
        notification.setBindingSid("");
        notification.setIdentitySid("");
        notification.setSubbedMarketing(false);
        dogNotificationRepositoryImpl.update(notification);
        return true;
    }

    public boolean deleteTwilioSubscriptions(){
        return twilioService.deleteAllSubscriptions();
    }

    public void sendAppointmentReminders(AppointmentReminderBody[] appointments){
        for(AppointmentReminderBody appt : appointments){
            twilioService.sendMessage(appt.getAddress(), appt.getMessage());
        }
    }

    public void sendMarketingNotifications(String marketingMessage){
        List<String> identities = dogNotificationRepositoryImpl.getNotificationsSubscribers();
        twilioService.broadcastMarketingNotification(identities, marketingMessage);
    }
}
