package ru.knapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@Api(tags = "HelloController TAG", value = "Мой самый лучший контррллер", hidden = true)
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    @ApiOperation(value = "value=Метод очень важное приветствие", notes = "notes = ЗАметки о doGet Hello")
    public String doGet() {
        return "<h1>Hello, from webmvc Controller! %s</h1>".formatted(LocalDateTime.now());
    }
}