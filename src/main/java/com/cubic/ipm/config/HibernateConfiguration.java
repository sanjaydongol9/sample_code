/**
 * Copyright 2016 (C) Cubic Technologies LLC
 * All Rights Reserved
 * @author Sanjay Dongol
 */

package com.cubic.ipm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.cubic.ipm.*" })
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

	@Value("${jdbc.driverClassName}")
	private String driverName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String userName;

	@Value("${jdbc.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hbDialect;

//	@Value("${hibernate.show_sql}")
//	private String hbShowSql;

	@Value("${hibernate.format_sql}")
	private String hbFormatSql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbDdlAuto;

//	@Value("${hibernate.hbm2ddl.import_files}")
//	private String hbImportFiles;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.cubic.ipm.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hbDialect);
		//properties.put("hibernate.show_sql", hbShowSql);
		properties.put("hibernate.format_sql", hbFormatSql);
		properties.put("hibernate.hbm2ddl.auto", hbDdlAuto);
		//properties.put("hibernate.hbm2ddl.import_files", hbImportFiles);

		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

	/* To work for Property File */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
