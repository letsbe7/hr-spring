package com.spring.hr.letsbe.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
@MapperScan(
        basePackages = "com.spring.hr.letsbe",
        sqlSessionFactoryRef = "orcl_ssf",
        sqlSessionTemplateRef = "orcl_sst"
)
class SqlSessionConfiguration {

    @Autowired
    ApplicationContext applicationContext;

    @Bean(name = "orcl_ssf")
    SqlSessionFactory getSqlSessionFactory(@Qualifier("orcl_hikari_ds") DataSource ds) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(ds)
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sqlmap/*.xml"))
        return sqlSessionFactoryBean.getObject()
    }

    @Bean(name = "orcl_sst")
    SqlSessionTemplate getSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(getSqlSessionFactory())
    }

}
