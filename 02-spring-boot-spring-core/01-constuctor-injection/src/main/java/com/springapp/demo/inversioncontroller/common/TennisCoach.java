package com.springapp.demo.inversioncontroller.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach {
    public  TennisCoach(){
        System.out.println("In Constuctor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Prctice your back hand valley ! ";
    }
}
