package com.example.puppynotificationcenter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UpdateDogNotificationException extends RuntimeException {

    public UpdateDogNotificationException(){
        super();
    }

    public UpdateDogNotificationException(String message) {
        super(message);
    }

    public UpdateDogNotificationException(Throwable cause) {
        super(cause);
    }

    public UpdateDogNotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
