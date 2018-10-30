package com.fenlan.spring.beans.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {

    @Pointcut("execution(* com.fenlan.spring.beans.bean.MyServiceImpl.save())")
    public void save() {}

    @Before("save()")
    public void beforeAct() {
        System.out.println("NotVeryUsefulAspect : beforeAct()");
    }

    @AfterReturning("save()")
    public void afterReturn() {
        System.out.println("NotVeryUsefulAspect : afterReturn()");
    }

    @Around("save()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("NotVeryUsefulAspect : around() before");
        pjp.proceed();
        System.out.println("NotVeryUsefulAspect : around() after");
    }

    @Before(value = "execution(* com.fenlan.spring.beans.bean.MyServiceImpl.save()) && args(param))", argNames = "param")
    public void beforeActArgs(String param) {
        System.out.println("NotVeryUsefulAspect : beforeAct("+param+")");
    }
}
