package ru.knapp.service;


import org.springframework.beans.factory.annotation.Value;

public class MyService {
    @Value("${my-webapp.myService.val}")
    private String myPropertyVal;

    public String getMyServiceMethod() {
        return "My property is %s".formatted(myPropertyVal);
    }
}
