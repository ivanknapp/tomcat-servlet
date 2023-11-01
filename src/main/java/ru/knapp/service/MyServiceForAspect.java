package ru.knapp.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyServiceForAspect {
    @Value("${my-webapp.MyServiceForAspect.val}")
    private String myPropertyVal;

    public String getMyServiceMethod() {
        return "My Aspect property is %s".formatted(myPropertyVal);
    }
}
