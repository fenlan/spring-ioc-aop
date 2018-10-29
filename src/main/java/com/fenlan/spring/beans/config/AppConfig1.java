package com.fenlan.spring.beans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig.class)
public class AppConfig1 {

    public class Foo {
        // @Autowired
        private Bar bar;

//        public Foo(Bar bar) {
//            this.bar = bar;
//        }

        public void save() {
            System.out.println("Foo : save()");
            bar.save();
        }

        @Autowired
        public void setBar(Bar bar) {
            this.bar = bar;
        }
    }

    public class Bar {

        public void save() {
            System.out.println("Bar : save()");
        }
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }
}
