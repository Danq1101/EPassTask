package com.example.task.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserLoginController {

    @GetMapping("/ePass/login")
    public String home(){
        return "login";
    }


}
