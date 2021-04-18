package com.example.puppynotificationcenter.services;

import com.example.puppynotificationcenter.repositories.TwilioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class TwilioService  {
    @Autowired
    private NotificationSubscriptionDaoImpl notificationSubscriptionDaoImpl;
    @Autowired
    private TwilioRepositoryImpl twilioRepositoryImpl;
//    public TwilioService() {
//        twilioRepository = new TwilioRepositoryImpl();
//    }
    public TwilioService(){ }

    public void sendMessage(String toPhoneNumber, String body) {
        String sid = twilioRepositoryImpl.createMessage(toPhoneNumber, body);
        System.out.println(sid);
    }

    public void broadcastMessageNotification(List<String> identities, String body) {
        String sid = twilioRepositoryImpl.createNotifications(identities, body);
    }

    public HashMap<String, String> setupSubscription(String toPhoneNumber) {
        HashMap<String, String> subscription = twilioRepositoryImpl.createBinding(toPhoneNumber);
        return subscription;
    }

    public boolean deleteSubscription(String identity){
        return twilioRepositoryImpl.deleteBinding(identity);
    }
}
