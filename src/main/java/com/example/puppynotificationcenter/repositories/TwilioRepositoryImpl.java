package com.example.puppynotificationcenter.repositories;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.notify.v1.Service;
import com.twilio.rest.notify.v1.service.Binding;
import com.twilio.rest.notify.v1.service.BindingDeleter;
import com.twilio.rest.notify.v1.service.Notification;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class TwilioRepositoryImpl implements TwilioRepository {

//    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID = "AC4e5291dddcf44d59d36745b8440bf34c";
//    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN = "7a102292e4572aca9bfc2b9ae65dbd90";
//    @Value("${twilio.phone-number}")
    private String PHONE_NUMBER = "+13235535700";
    private Service msgService;

    public TwilioRepositoryImpl() {
        twilioInit();
        msgService = Service.creator().create();
    }

    private void twilioInit() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public HashMap<String, String> createBinding(String address) {
        String identity = "";
        Binding binding = Binding.creator(msgService.getSid(), identity, Binding.BindingType.APN, address).create();
        HashMap<String, String> bindingData = new HashMap<>();
        bindingData.put(binding.getSid(), binding.getIdentity());
        return bindingData;
    }

    public Binding retrieveBinding(String bindingSid) {
        Binding binding = Binding.fetcher(msgService.getSid(), bindingSid).fetch();
        return binding;
    }

    public boolean deleteBinding(String bindingSid){
        return Binding.deleter(msgService.getSid(), bindingSid).delete();
    }

    @Override
    public String createMessage(String toPhoneNumber, String body) {
        Message message = Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(PHONE_NUMBER), body).create();
        return message.getSid();
    }
    @Override
    public String createNotifications(List<String> identities, String body) {
        Notification notification = Notification.creator(msgService.getSid()).setIdentity(identities)
                .setBody(body).create();
        return notification.getSid();
    }
}
