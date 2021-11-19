package com.callor.jc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.callor.jc.repository")
// main/resources에 들어있으면 classpath로 가져올 수 있음
@PropertySource("classpath:db.properties")
public class MyBatisConfig {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    private final StandardPBEStringEncryptor encryptor;
    public MyBatisConfig(StandardPBEStringEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    // dataSource
    private DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName(driver);
        ds.setUrl(url);

        // 암호화된 username과 password를 복구하기
        String planUsername = encryptor.decrypt(username);
        String planPassword = encryptor.decrypt(password);

        ds.setUsername(planUsername);
        ds.setPassword(planPassword);

        return ds;
    }

    //SqlSessionFactiory
    // 여기는 반드시 시스템에서 사용할 수 있도록 Bean으로 설정한다.
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
        // 위에 만들어놓은 DataSource를 가져오는 것
        sqlBean.setDataSource(this.getDataSource());
        // vo객체들이 있는 곳을 지정
        sqlBean.setTypeAliasesPackage("com.callor.js.models");
        return sqlBean;
    }

    //SqlSessionTemplate
//    시스템에서 sqlSessionFactory를 주입한다.
    // 여기도 반드시 Bean으로 등록한다.
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        return sqlSessionTemplate;
    }
}