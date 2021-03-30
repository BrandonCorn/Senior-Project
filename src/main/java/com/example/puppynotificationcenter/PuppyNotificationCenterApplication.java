package com.example.puppynotificationcenter;

import com.example.puppynotificationcenter.dao.DogNotificationDaoImpl;
import com.example.puppynotificationcenter.models.DogNotification;
import com.example.puppynotificationcenter.repositories.DogNotificationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PuppyNotificationCenterApplication {
	@Autowired
	private static Environment env;
//	private static DriverManagerDataSource dataSource = new DriverManagerDataSource();
	@Autowired
    private static DataSource dataSource;

	private static DogNotificationDaoImpl dao;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PuppyNotificationCenterApplication.class, args);
//		DataSource dataSource = (DataSource)context.getBean("mysqlDataSource");
//		JdbcTemplate template = new JdbcTemplate(dataSource);
//		template.execute("Create TABLE IF NOT EXISTS DogNotifications(" +
//				"id INT, phoneNumber VARCHAR(12), email VARCHAR(30), subbedMarketing BOOLEAN, subbedReminders BOOLEAN)");
//		DogNotificationDaoImpl dao = new DogNotificationDaoImpl((DataSource)context.getBean("mysqlDataSource"));
		DogNotification notification = new DogNotification();
		notification.setId((long)1);
		notification.setPhoneNumber("7067612848");
		notification.setEmail("brandon@gmail.com");
		notification.setSubbedMarketing(true);
		notification.setSubbedReminders(true);
		int created = dao.create(notification);
		System.out.println("created: " + created);


//		DogNotificationRepositoryImpl dogRepo = new DogNotificationRepositoryImpl();
//		DogNotification notification = new DogNotification();
//		notification.setId((long)1);
//		notification.setPhoneNumber("7067612848");
//		notification.setEmail("brandon@gmail.com");
//		notification.setSubbedMarketing(true);
//		notification.setSubbedReminders(true);
//		int created = dogRepo.add(notification);
//		System.out.println("created: " + created);
//		DogNotification retrieved = dogRepo.get("7067612848", "brandon@gmail.com");
//		System.out.println("dog retrieved: " + retrieved.getEmail());
//		template.execute("DROP TABLE DogNotifications");
	}
}

//		DogNotificationDaoImpl dao = new DogNotificationDaoImpl((DataSource)context.getBean("mysqlDataSource"));
//		DogNotification notification = new DogNotification();
//		notification.setId((long)1);
//		notification.setPhoneNumber("7067612848");
//		notification.setEmail("brandon@gmail.com");
//		notification.setSubbedMarketing(true);
//		notification.setSubbedReminders(true);
//		int created = dao.create(notification);
//		System.out.println("created: " + created);
