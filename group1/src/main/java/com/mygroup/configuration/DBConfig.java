package com.mygroup.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*import com.abcd.group1.model.Job;
import com.abcd.group1.model.Test;
import com.abcd.group1.model.Test1;
import com.abcd.group1.model.UserDetails;
import com.abcd.group1.model.UserProfile;
*/

@ComponentScan(basePackages="com.mygroup")
@Configuration
@EnableTransactionManagement
public class DBConfig {
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//Class modelclasses[] = {UserDetails.class, UserProfile.class, Job.class};
		
		//return lsf.addAnnotatedClasses(modelclasses)
		return lsf.scanPackages("com.mygroup.model")
		/* 
				  .addAnnotatedClass(Test1.class)
				  .addAnnotatedClass(UserDetails.class)
				  .addAnnotatedClass(UserProfile.class)
				  .addAnnotatedClass(Job.class)  */
		   .buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("system");
	    dataSource.setPassword("password");
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}

}
