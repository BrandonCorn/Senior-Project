package com.example.puppynotificationcenter.repositories;


import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.notify.v1.Service;
import com.twilio.rest.notify.v1.ServiceFetcher;
import com.twilio.rest.notify.v1.service.Binding;
import com.twilio.rest.notify.v1.service.BindingDeleter;
import com.twilio.rest.notify.v1.service.Notification;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.Bindings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class TwilioRepositoryImpl implements TwilioRepository {

//    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID = "AC4e5291dddcf44d59d36745b8440bf34c";
//    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN = "7a102292e4572aca9bfc2b9ae65dbd90";
//    @Value("${twilio.phone-number}")
    private String PHONE_NUMBER = "+13235535700";
    private String NOTIFY_SERVICE_SID = "ISc990790d0e35e2fe1f29c6e1bde367da";
    private String NOTIFY_SERVICE_CREDENTIAL_SID = "CR02b3042cc122090742f0fb1afaf344fe";
    private Service notifyService;

    public TwilioRepositoryImpl() {
        twilioInit();
        notifyService = Service.fetcher(NOTIFY_SERVICE_SID).fetch();
    }

    private void twilioInit() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Override
    public HashMap<String, String> createBinding(String address) {
        String identity = UUID.randomUUID().toString();
        address = address.replace("-", "");
        address = "+1" + address;
        Binding binding = Binding.creator(notifyService.getSid(), identity, Binding.BindingType.SMS, address).create();
        HashMap<String, String> bindingData = new HashMap<>();
        bindingData.put(binding.getSid(), binding.getIdentity());

        return bindingData;
    }

    @Override
    public Binding retrieveBinding(String bindingSid) {
        Binding binding = Binding.fetcher(notifyService.getSid(), bindingSid).fetch();
        return binding;
    }

    @Override
    public boolean deleteBinding(String bindingSid){
        return Binding.deleter(notifyService.getSid(), bindingSid).delete();
    }

    @Override
    public String createMessage(String toPhoneNumber, String body) {
        Message message = Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(PHONE_NUMBER), body).create();
        return message.getSid();
    }

    @Override
    public String createNotifications(List<String> identities, String body) {
        Notification notification = Notification.creator(notifyService.getSid()).setIdentity(identities)
                .setBody(body).create();
        return notification.getSid();

    }

    public ResourceSet<Binding> getAllBindings(){
        ResourceSet<Binding> bindings = Binding.reader(notifyService.getSid()).read();
        return bindings;
    }
}
