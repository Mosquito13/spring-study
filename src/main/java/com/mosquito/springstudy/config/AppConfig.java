package com.mosquito.springstudy.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.mosquito.springstudy")
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public DataSource buildDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(5);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(3000);

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean buildSessionFactory() {
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(buildDataSource());
		sessionFactory.setPackagesToScan("com.mosquito.springstudy.entity");
		sessionFactory.setHibernateProperties(props);

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager buildTransactionManager(SessionFactory factory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();

		manager.setSessionFactory(factory);

		return manager;
	}
}
