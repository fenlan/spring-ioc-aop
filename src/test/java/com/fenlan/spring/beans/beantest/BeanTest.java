package com.fenlan.spring.beans.beantest;

import com.fenlan.spring.beans.bean.MyService;
import com.fenlan.spring.beans.config.AppConfig;
import com.fenlan.spring.beans.config.AppConfig1;
import com.fenlan.spring.beans.config.ServiceConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class BeanTest {

    @Test
    public void call() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService service = (MyService) context.getBean("service");
        service.save();
        System.out.println(service.hashCode());

        MyService service1 = (MyService) context.getBean("service");
        service1.save();
        System.out.println(service1.hashCode());
        Resource resource = context.getResource("classpath:jdbc.properties");
        try {
            System.out.println(resource.contentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void depCall() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
        AppConfig1.Foo foo = (AppConfig1.Foo) context.getBean("foo");
        foo.save();
        MyService service = (MyService) context.getBean("service");
        service.save();
        ((AnnotationConfigApplicationContext) context).close();
    }

    @Test
    public void argCall() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        ServiceConfig.DataSource dataSource = (ServiceConfig.DataSource) context.getBean("dataSource");
    }
}
