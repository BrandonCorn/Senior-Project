package com.example.puppynotificationcenter.dao;

import com.example.puppynotificationcenter.dao.DogNotificationDao;
import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.models.DogNotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class DogNotificationDaoImpl implements DogNotificationDao {
    private JdbcTemplate template;
    @Resource(name = "mysqlDataSource")
    private DataSource ds;

    public DogNotificationDaoImpl(){
        template = new JdbcTemplate(ds);
    }
//    public DogNotificationDaoImpl(DataSource ds){
//        template = new JdbcTemplate(ds);
//    }

    @Override
    public int create(DogNotification dogNotification) {
        return template.update("INSERT INTO DogNotifications (id, phoneNumber, email, subbedMarketing, subbedReminders)" +
                " VALUES(?,?,?,?,?)", dogNotification.getId(), dogNotification.getPhoneNumber(), dogNotification.getEmail(), dogNotification.getSubbedMarketing(),
                dogNotification.getSubbedReminders());
    }

    @Override
    public DogNotification retrieve(String phoneNumber, String email) {
        String sql = "SELECT * FROM DogNotifications WHERE phoneNumber = '"+phoneNumber+"' and email = '"+email+"';";
        List<DogNotification> notification = template.query(sql, new DogNotificationMapper());
        return notification.get(0);
    }

    @Override
    public int delete(DogNotification dogNotification) {
        String sql = "DELETE FROM DogNotifications WHERE id = '"+dogNotification.getId()+"';";
        return template.update(sql);
    }

    @Override
    public int update(DogNotification dogNotification) {
        String sql = "UPDATE DogNotifications set phoneNumber = '"+dogNotification.getPhoneNumber()+"', email = " +
                "'"+dogNotification.getEmail()+"', subbedMarketing = '"+dogNotification.getSubbedMarketing()+"', " +
                "'"+dogNotification.getSubbedReminders()+"' where id = '"+dogNotification.getId()+"';";
        return template.update(sql);
    }
}
