package com.spring.hr.letsbe.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class HikariDataSourceTransactionConfiguration {

    @Bean
    DataSourceTransactionManager transactionManager (@Qualifier("orcl_hikari_ds") DataSource ds) {
        return new DataSourceTransactionManager(ds)
    }
}
