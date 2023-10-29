package com.weed.account_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class ViewController {
    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/public/register")
    public String register() {
        return "register";
    }

    @GetMapping("/user/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}
