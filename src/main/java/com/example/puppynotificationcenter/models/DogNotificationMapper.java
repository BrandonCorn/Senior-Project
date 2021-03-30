package com.example.puppynotificationcenter.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DogNotificationMapper implements RowMapper<DogNotification> {
    @Override
    public DogNotification mapRow(ResultSet rs, int rowNum) throws SQLException {
        DogNotification notification = new DogNotification();
        notification.setId(rs.getLong("id"));
        notification.setPhoneNumber(rs.getString("phoneNumber"));
        notification.setEmail(rs.getString("email"));
        notification.setSubbedMarketing(rs.getBoolean("subbedMarketing"));
        notification.setSubbedReminders(rs.getBoolean("subbedReminders"));
        return notification;
    }
}
