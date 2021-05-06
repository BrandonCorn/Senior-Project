package com.example.puppynotificationcenter.controllers.schemas;

public class MarketingNotificationBody {
    private String message;

    public MarketingNotificationBody(){

    }
    public MarketingNotificationBody(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
