package com.fenlan.spring.beans.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {

    @Before("execution(* com.fenlan.spring.beans.bean.MyServiceImpl.save(..))")
    public void beforeAct() {
        System.out.println("NotVeryUsefulAspect : beforeAct()");
    }
}
