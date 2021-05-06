package com.example.puppynotificationcenter;


import com.example.puppynotificationcenter.services.DogNotificationService;
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
				" NOT NULL, bindingSid VARCHAR(50) DEFAULT ' ', identitySid VARCHAR(50) DEFAULT ' ', " +
				"PRIMARY KEY(id), UNIQUE(phoneNumber, email));");

	}
}




