package com.example.puppynotificationcenter;

import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.repositories.DogNotificationRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
public class PuppyNotificationCenterApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PuppyNotificationCenterApplication.class, args);
		DataSource dataSource = (DataSource)context.getBean("mysqlDataSource");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.execute("CREATE TABLE IF NOT EXISTS DogNotifications(" +
				"id BIGINT(20) NOT NULL AUTO_INCREMENT, phoneNumber VARCHAR(12) NOT NULL, email VARCHAR(30) NOT NULL, subbedMarketing BOOLEAN" +
				" NOT NULL, subbedReminders BOOLEAN NOT NULL, bindingSid VARCHAR(30) NOT NULL, identitySid VARCHAR(30) NOT NULL, " +
				"PRIMARY Key(id), CONSTRAINT UC_Dog_Notification UNIQUE(phoneNumber,email, bindingSid, identitySid));");


		DogNotificationRepositoryImpl impl = context.getBean(DogNotificationRepositoryImpl.class);
		DogNotification	dogNotif = new DogNotification("706-761-2848", "test@test.com", false, false);
		impl.add(dogNotif);
		impl.add(dogNotif);

		DogNotification notification = impl.get("706-761-2848", "test@test.com");
		System.out.println(notification.getEmail());
//		notification.setBindingSid("123456754848383828");
//		notification.setIdentitySid("18478231209");
//		impl.update(notification);
		System.out.println(impl.get(notification.getPhoneNumber(), notification.getEmail()).getEmail());

	}
}




