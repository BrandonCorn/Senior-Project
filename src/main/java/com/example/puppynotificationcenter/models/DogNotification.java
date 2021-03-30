package com.example.puppynotificationcenter.models;


public class DogNotification {

    private Long id;
    private String phoneNumber;
    private String email;
    private Boolean subbedReminders;
    private Boolean subbedMarketing;

    public DogNotification(String phoneNumber, String email, Boolean subbedReminders, Boolean subbedMarketing) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subbedReminders = subbedReminders;
        this.subbedMarketing = subbedMarketing;
    }

    public DogNotification() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSubbedReminders() {
        return subbedReminders;
    }

    public void setSubbedReminders(Boolean subbedReminders) {
        this.subbedReminders = subbedReminders;
    }

    public Boolean getSubbedMarketing() {
        return subbedMarketing;
    }

    public void setSubbedMarketing(Boolean subbedMarketing) {
        this.subbedMarketing = subbedMarketing;
    }

}
