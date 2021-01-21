package com.krb.measurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;


@PropertySource({"classpath:application-internal.properties"})
@SpringBootApplication(scanBasePackages = { "com.krb"},exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
