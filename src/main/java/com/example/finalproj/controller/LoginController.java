package com.example.finalproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/login")
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
