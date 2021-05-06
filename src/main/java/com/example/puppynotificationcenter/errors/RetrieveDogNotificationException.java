package com.example.puppynotificationcenter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RetrieveDogNotificationException extends RuntimeException{

    public RetrieveDogNotificationException(){
        super();
    }

    public RetrieveDogNotificationException(String message){
        super(message);
    }

    public RetrieveDogNotificationException(Throwable cause){
        super(cause);
    }

    public RetrieveDogNotificationException(String message, Throwable cause){
        super(message, cause);
    }
}
