package com.example.puppynotificationcenter.controllers.schemas;

public class AppointmentReminderBody {

    private String address;
    private String message;

    public AppointmentReminderBody(){

    }

    public AppointmentReminderBody(String address, String message) {
        this.address = address;
        this.message = message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
