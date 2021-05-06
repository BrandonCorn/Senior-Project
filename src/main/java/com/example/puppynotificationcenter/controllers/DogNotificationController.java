package com.example.puppynotificationcenter.controllers;

import com.example.puppynotificationcenter.controllers.schemas.AppointmentReminderBody;
import com.example.puppynotificationcenter.controllers.schemas.MarketingNotificationBody;
import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.services.DogNotificationService;
import com.example.puppynotificationcenter.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
public class DogNotificationController {
    @Autowired
    DogNotificationService dogNotificationService;
    @Autowired
    TwilioService twilioService;

    @PostMapping("/create-notification-record")
    public DogNotification createNotificationRecord(@RequestBody DogNotification notification){
        try{
            return this.dogNotificationService.createDogNotificationRecord(notification);
        }
        catch(RuntimeException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete-notification-record")
    public boolean deleteNotificationRecord(@RequestBody DogNotification notification){
        try{
            return this.dogNotificationService.deleteDogNotificationRecord(notification.getPhoneNumber(), notification.getEmail());
        }
        catch(Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/create-notification-subscription")
    public DogNotification createNotificationSubscription(@RequestBody DogNotification notification){
        try{
            return this.dogNotificationService.createDogNotificationSubscription(notification.getPhoneNumber(), notification.getEmail());
        }
        catch(Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete-notification-subscription")
    public boolean deleteDogNotificationSubscription(@RequestBody DogNotification notification) {
        try{
            return this.dogNotificationService.deleteDogNotificationSubscription(notification.getPhoneNumber(), notification.getEmail());
        }
        catch(Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/send-appointment-reminders")
    public String sendAppointmentReminders(@RequestBody AppointmentReminderBody[] appointments){
        this.dogNotificationService.sendAppointmentReminders(appointments);
        return "Appointment Reminders Sent";
    }

    @PostMapping("/send-marketing-notifications")
    public String sendMarketingNotifications(@RequestBody MarketingNotificationBody marketingNotification){
        this.dogNotificationService.sendMarketingNotifications(marketingNotification.getMessage());
        return "Notifications sent";
    }


    @DeleteMapping("/delete-subscriptions")
    public boolean deleteAllSubscriptions(){
        return this.dogNotificationService.deleteTwilioSubscriptions();
    }
}
