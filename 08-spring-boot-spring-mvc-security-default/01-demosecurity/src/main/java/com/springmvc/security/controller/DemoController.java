package com.springmvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeader(){
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystem(){
        return
     "systems";
    }


    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
