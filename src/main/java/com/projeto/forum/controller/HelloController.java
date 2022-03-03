package com.projeto.forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("begin")
public class HelloController {

    @GetMapping
    public String getHello() {
        return "hello spring!";
    }

}
