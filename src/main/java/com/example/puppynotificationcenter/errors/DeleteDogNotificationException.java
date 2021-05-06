package com.example.puppynotificationcenter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DeleteDogNotificationException extends RuntimeException {

    public DeleteDogNotificationException(){
        super();
    }

    public DeleteDogNotificationException(String message) {
        super(message);
    }

    public DeleteDogNotificationException(Throwable cause) {
        super(cause);
    }

    public DeleteDogNotificationException(String message, Throwable cause){
        super(message, cause);
    }
}
