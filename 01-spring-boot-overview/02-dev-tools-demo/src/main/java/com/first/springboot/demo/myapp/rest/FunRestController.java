package com.first.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/"that return Hello Gumiho
    @GetMapping("/")
    public String SayHello(){
        String name = "Hello --->" + coachName + teamName;
        return name;
    }

    @GetMapping("/smossne")
    public  String Smos(){
        return  "Hello mnus smos";
    }

    @GetMapping("/fortune")
    public  String getDailyFortune(){
        return "Today is your lucky day";
    }

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;






}//end of class
