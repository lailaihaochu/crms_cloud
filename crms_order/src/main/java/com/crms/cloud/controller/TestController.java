package com.crms.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${spring.application.name}")
    String string;
    @RequestMapping("/list")
    public String test(){
        return string;
    }
}
