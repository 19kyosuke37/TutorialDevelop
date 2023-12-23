package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class logoutController {

    @PostMapping("/logout")
    public String postLogin() {
        return "redirect:/login";

    }

}
