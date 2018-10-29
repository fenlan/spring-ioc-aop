package com.fenlan.spring.beans.config;

import com.fenlan.spring.beans.bean.MyService;
import com.fenlan.spring.beans.bean.MyServiceImpl;
import com.fenlan.spring.beans.bean.MyServiceImpl1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "service", initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public MyService myService1() {
        return new MyServiceImpl1();
    }
}