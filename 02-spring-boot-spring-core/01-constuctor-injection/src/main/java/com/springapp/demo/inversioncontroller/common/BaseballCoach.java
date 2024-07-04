package com.springapp.demo.inversioncontroller.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In Constuctor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in betting practice !";
    }
}
