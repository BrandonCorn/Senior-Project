package repositories;

import models.UserNotification;

public class CreateUserNotificationDto implements UserNotificationDto{
    @Override
    public Integer create(UserNotification notification) {
        return null;
    }

    @Override
    public Integer update(UserNotification notification) {
        return null;
    }

    @Override
    public UserNotification retrieve(String phone_number, String composite) {
        return null;
    }

    @Override
    public Integer delete(String phone_number, String composite) {
        return null;
    }
}
