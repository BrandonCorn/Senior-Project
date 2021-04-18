package com.example.puppynotificationcenter.services;

import com.example.puppynotificationcenter.models.UserNotification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

public class UserNotificationDaoImpl implements UserNotificationDao {
//    private final EntityManager em = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
    @PersistenceContext
    private EntityManager em;
    @Override
    public void create(UserNotification userNotification) {
        em.getTransaction().begin();
        em.persist(userNotification);
        em.getTransaction().commit();
    }

    @Override
    public UserNotification retrieve(String phoneNumber, String email) {
        TypedQuery<UserNotification> query = em.createQuery("SELECT un FROM UserNotification un WHERE " +
                "un.phoneNumber = :phoneNumber AND un.email = :email", UserNotification.class);
        query.setParameter("phoneNumber", phoneNumber);
        query.setParameter("email", email);
        UserNotification userNotification = query.getSingleResult();
        em.detach(userNotification);
        return userNotification;
    }

    @Override
    public void delete(UserNotification userNotification) {
        em.getTransaction().begin();
        em.remove(userNotification);
        em.getTransaction().commit();
    }

    @Override
    public void update(UserNotification userNotification) {
        em.detach(userNotification);
        em.getTransaction().begin();
        em.merge(userNotification);
        em.getTransaction().commit();
    }
}
