package com.fenlan.spring.beans.bean;

public class MyServiceImpl1 implements MyService {

    @Override
    public void init() {
        System.out.println("MyServiceImpl1 : init()");
    }

    @Override
    public void save() {
        System.out.println("MyServiceImpl1 : save()");
    }

    @Override
    public void cleanup() {
        System.out.println("MyServiceImpl1 : cleanup");
    }
}
