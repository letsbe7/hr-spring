package com.spring.hr.letsbe.config

import org.apache.tomcat.jdbc.pool.DataSourceFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ['com.spring.hr.letsbe'])
class PersistenceContext {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource ds, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean()
        entityManagerFactoryBean.setDataSource(ds)
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter())
        entityManagerFactoryBean.setPackagesToScan('com.spring.hr.letsbe')

        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles())
        Properties prop = new Properties();
        if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT)) {
            prop.put("hibernate.show_sql", true)
            prop.put("hibernate.format_sql", true)
            prop.put("hibernate.hbm2ddl.auto", "create-drop")
            prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
            prop.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy")

        } else if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
            prop.put("hibernate.show_sql", true)
            prop.put("hibernate.format_sql", true)
            prop.put("hibernate.hbm2ddl.auto", "none")
            prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect")
            prop.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy")
        }

        entityManagerFactoryBean.setJpaProperties(prop)
        return entityManagerFactoryBean
    }



    @Bean
    JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager()
        transactionManager.setEntityManagerFactory(entityManagerFactory)
        return transactionManager
    }


}
