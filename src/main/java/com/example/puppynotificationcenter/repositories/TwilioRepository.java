package com.example.puppynotificationcenter.repositories;

import com.twilio.rest.notify.v1.service.Binding;

import java.util.HashMap;
import java.util.List;

public interface TwilioRepository {

    public HashMap<String, String> createBinding(String address);
    public Binding retrieveBinding(String bindingSid);
    public boolean deleteBinding(String bindingSid);
    public String createMessage(String toPhoneNumber, String body);
    public String createNotifications(List<String> identities, String body);
}
