package models;

import javax.persistence.*;

@Entity
@Table(name = "UserNotifications")
public class UserNotification {
    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "phone_number", unique = true)
    private String phone_number;

    @Column(name = "notify_comp", unique = true)
    private String notifyComp;

    @Column(name = "subbed_reminders")
    private Boolean subbedReminders;

    @Column(name = "subbed_marketing")
    private Boolean subbedMarketing;



}
