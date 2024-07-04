package com.springapp.demo.inversioncontroller.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{
    public  CricketCoach(){
        System.out.println("In Constuctor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!5!!ggg";
    }
}
