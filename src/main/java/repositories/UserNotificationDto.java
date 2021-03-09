package repositories;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import models.UserNotification;

public interface UserNotificationDto {
    Integer create(UserNotification notification);
    Integer update(UserNotification notification);
    UserNotification retrieve(String phone_number, String composite);
    Integer delete(String phone_number, String composite);
}
