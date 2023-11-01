package ru.knapp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.knapp.service.MyServiceForAspect;

@Aspect
@Component
public class MyVeryUsefulAspect {
    private final MyServiceForAspect myServiceForAspect;

    public MyVeryUsefulAspect(MyServiceForAspect myServiceForAspect) {
        this.myServiceForAspect = myServiceForAspect;
    }

    @Before("execution(* ru.knapp.controller.HelloController.doGet(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("MyVeryUsefulAspect execute : %s %s".formatted(joinPoint.getSignature().getName(), myServiceForAspect.getMyServiceMethod()));
    }
}