package com.fenlan.spring.beans.bean;

import javax.annotation.PostConstruct;

public class MyServiceImpl implements MyService {

    @Override
    public void init() {
        System.out.println("MyServiceImpl : init()");
    }

    @PostConstruct
    public void prepare() {
        System.out.println("MyServiceImpl : prepare()");
    }

    @Override
    public void save() {
        System.out.println("MyServiceImpl : save()");
    }

    public void save(String param) {
        System.out.println("MyServiceImpl : save(" + param + ")");
    }

    @Override
    public void cleanup() {
        System.out.println("MyServiceImpl : cleanup()");
    }
}
