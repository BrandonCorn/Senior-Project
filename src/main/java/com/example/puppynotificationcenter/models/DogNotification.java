package com.example.puppynotificationcenter.models;


public class DogNotification {

    private Long id;
    private String phoneNumber;
    private String email;
    private Boolean subbedReminders;
    private Boolean subbedMarketing;
    private String bindingSid;
    private String identitySid;

    public DogNotification(String phoneNumber, String email, Boolean subbedReminders, Boolean subbedMarketing) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subbedReminders = subbedReminders;
        this.subbedMarketing = subbedMarketing;
        bindingSid = "";
        identitySid = "";
    }

    public DogNotification(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public DogNotification() {

    }

    public Long getId() { return id; }

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

    public Boolean getSubbedMarketing() {
        return subbedMarketing;
    }

    public void setSubbedMarketing(Boolean subbedMarketing) {
        this.subbedMarketing = subbedMarketing;
    }

    public String getBindingSid() { return bindingSid; }

    public void setBindingSid(String bindingSid) { this.bindingSid = bindingSid; }

    public String getIdentitySid() { return identitySid; }

    public void setIdentitySid(String identitySid) { this.identitySid = identitySid; }

    @Override
    public boolean equals(Object o){
        DogNotification notification = (DogNotification) o;
        if (this.getPhoneNumber().equals(notification.getPhoneNumber())){
            return true;
        }
        else return false;
    }

}

