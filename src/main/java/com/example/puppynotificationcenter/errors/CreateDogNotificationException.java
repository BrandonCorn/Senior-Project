package com.example.puppynotificationcenter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CreateDogNotificationException extends RuntimeException{

    public CreateDogNotificationException(){
        super();
    }

    public CreateDogNotificationException(String message){
        super(message);
    }

    public CreateDogNotificationException(Throwable cause){
        super(cause);
    }

    public CreateDogNotificationException(String message, Throwable cause){
        super(message, cause);
    }

}
