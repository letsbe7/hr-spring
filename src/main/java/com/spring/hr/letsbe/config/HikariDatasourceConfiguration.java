package com.spring.hr.letsbe.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

@Configuration
public class HikariDatasourceConfiguration {

    static final Logger log = LoggerFactory.getLogger(HikariDatasourceConfiguration.class);

    @Autowired
    Environment env;

    @Bean(name = "orcl_hikari_ds")
    DataSource getDataSource() throws Exception {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        Properties prop = new Properties();

        if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT)) {
            prop.load(DataSourceFactory.class.getClassLoader().getResourceAsStream("application-dev.properties"));
            log.info("datasource -> dev");
        } else if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
            prop.load(DataSourceFactory.class.getClassLoader().getResourceAsStream("application-prod.properties"));
            log.info("datasource -> prod");
        }
        return new HikariDataSource(new HikariConfig(prop));
    }

}
