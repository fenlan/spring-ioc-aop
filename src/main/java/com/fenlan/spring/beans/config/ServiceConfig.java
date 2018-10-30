package com.fenlan.spring.beans.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class ServiceConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return new DataSource(url, username, password);
    }

    public class DataSource {
        public DataSource(String url, String username, String passwod) {
            System.out.println("jdbc.url: "+ url + "\tjdbc.username: " + username + "\tjdbc.password: " + passwod);
        }
    }
}
