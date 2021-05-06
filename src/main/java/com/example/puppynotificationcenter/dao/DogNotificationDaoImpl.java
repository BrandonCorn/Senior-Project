package com.example.puppynotificationcenter.dao;

import com.example.puppynotificationcenter.dao.DogNotificationDao;
import com.example.puppynotificationcenter.errors.CreateDogNotificationException;
import com.example.puppynotificationcenter.errors.DeleteDogNotificationException;
import com.example.puppynotificationcenter.errors.RetrieveDogNotificationException;
import com.example.puppynotificationcenter.errors.UpdateDogNotificationException;
import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.models.DogNotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Component
public class DogNotificationDaoImpl implements DogNotificationDao {

    private JdbcTemplate template;

    @Autowired
    public DogNotificationDaoImpl(DataSource ds){
        template = new JdbcTemplate(ds);
    }


    @Override
    public int create(DogNotification dogNotification) {
        try {
            return template.update("INSERT INTO DogNotifications (id, phoneNumber, email, subbedMarketing, bindingSid, identitySid)" +
                            " VALUES(?,?,?,?,?,?)", dogNotification.getId(), dogNotification.getPhoneNumber(), dogNotification.getEmail(), dogNotification.getSubbedMarketing(),
                     dogNotification.getBindingSid(), dogNotification.getIdentitySid());
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
            throw new CreateDogNotificationException("Error creating Dog Notification Record, does this record exist already?", e.getCause());
        }
    }

    @Override
    public DogNotification retrieve(String phoneNumber, String email) throws IndexOutOfBoundsException {
        try {
            String sql = "SELECT * FROM DogNotifications WHERE phoneNumber = '" + phoneNumber + "' and email = '" + email + "';";
            List<DogNotification> notification = template.query(sql, new DogNotificationMapper());
            return notification.get(0);
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new RetrieveDogNotificationException("Error retrieving Dog Notification Record");
        }
    }

    public List<String> retrieveNotificationSubscribers() throws IndexOutOfBoundsException {
        try{
            String sql = "SELECT identitySid FROM DogNotifications WHERE subbedMarketing = TRUE;";
            List<String> identities = template.queryForList(sql, String.class);
            return identities;
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new RetrieveDogNotificationException("Error retrieving Dog Notification Records");
        }
    }

    @Override
    public int delete(String phoneNumber, String email) {
        String sql = "DELETE FROM DogNotifications WHERE phoneNumber = '"+ phoneNumber +"' AND email = '" + email + "';";
        int deleted = template.update(sql);
        if (deleted == 0) throw new DeleteDogNotificationException("Error deleting Dog Notification Record, does this record exist?");
        return deleted;
    }

    @Override
    public int update(DogNotification dogNotification) {
        try {
            String sql = "UPDATE DogNotifications set phoneNumber = '" + dogNotification.getPhoneNumber() + "', email = " +
                    "'" + dogNotification.getEmail() + "', subbedMarketing = " + dogNotification.getSubbedMarketing() + ", bindingSid = '" + dogNotification.getBindingSid() + "', " +
                    " identitySid = '" + dogNotification.getIdentitySid() + "' where id = '" + dogNotification.getId() + "';";
            return template.update(sql);
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
            throw new UpdateDogNotificationException("Error updating Dog Notification record");
        }
    }
}