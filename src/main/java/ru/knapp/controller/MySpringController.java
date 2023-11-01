package ru.knapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.knapp.service.MyService;

@Controller
public class MySpringController {
    private final MyService myService;

    public MySpringController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/spring")
    @ResponseBody
    public String doGet() {
        return "<h1>Hello, %s</h1>".formatted(myService.getMyServiceMethod());
    }

}