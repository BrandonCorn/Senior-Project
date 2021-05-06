package com.example.puppynotificationcenter.services;

import com.example.puppynotificationcenter.repositories.TwilioRepositoryImpl;
import com.twilio.base.ResourceSet;
import com.twilio.rest.notify.v1.service.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class TwilioService  {

    @Autowired
    private TwilioRepositoryImpl twilioRepositoryImpl;

    public TwilioService(){ }

    public void sendMessage(String toPhoneNumber, String body) {
        String sid = twilioRepositoryImpl.createMessage(toPhoneNumber, body);
        System.out.println(sid);
    }

    public void broadcastMarketingNotification(List<String> identities, String body) {
        String sid = twilioRepositoryImpl.createNotifications(identities, body);
    }

    public HashMap<String, String> setupSubscription(String toPhoneNumber) {
        HashMap<String, String> subscription = twilioRepositoryImpl.createBinding(toPhoneNumber);
        return subscription;
    }

    public boolean deleteSubscription(String bindingSid){
        return twilioRepositoryImpl.deleteBinding(bindingSid);
    }

    public boolean deleteAllSubscriptions(){
        ResourceSet<Binding> bindings = twilioRepositoryImpl.getAllBindings();
        for(Binding binding : bindings){
            System.out.println("bindings");
            System.out.println(binding.getSid());
            twilioRepositoryImpl.deleteBinding(binding.getSid());
        }
        ResourceSet<Binding> check = twilioRepositoryImpl.getAllBindings();
        for(Binding binding : bindings){
            System.out.println(binding.getSid());
        }
        return true;
    }
}
