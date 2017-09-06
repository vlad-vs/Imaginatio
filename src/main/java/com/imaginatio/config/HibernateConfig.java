package com.imaginatio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.imaginatio.dao")
public class HibernateConfig {

    @Autowired
    private Environment env;

    private final String DB_URL = "db_url";
    private final String DB_DRIVER_CLASS = "db_driver_class";
    private final String DB_USERNAME = "db_username";
    private final String DB_PASSWORD = "db_password";

    private final String DB_GENERATE_DDL = "hibernate.hbm2ddl.auto";
    private final String DB_DIALECT = "hibernate.dialect";
    private final String DB_SHOW_SQL = "hibernate.show_sql";


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.imaginatio.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(DB_DRIVER_CLASS));
        dataSource.setUrl(env.getProperty(DB_URL));
        dataSource.setUsername(env.getProperty(DB_USERNAME));
        dataSource.setPassword(env.getProperty(DB_PASSWORD));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(DB_GENERATE_DDL, env.getProperty(DB_GENERATE_DDL));
        properties.setProperty(DB_SHOW_SQL, env.getProperty(DB_SHOW_SQL));
        properties.setProperty(DB_DIALECT, env.getProperty(DB_DIALECT));
        return properties;
    }
}


