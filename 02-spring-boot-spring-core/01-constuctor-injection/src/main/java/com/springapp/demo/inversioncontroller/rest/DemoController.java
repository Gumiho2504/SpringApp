package com.springapp.demo.inversioncontroller.rest;

import com.springapp.demo.inversioncontroller.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a privat field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    private void DemoController (
            @Qualifier("aquatic") Coach theCoach
         ){
        System.out.println("In Constuctor: " + getClass().getSimpleName());
        myCoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public  String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String Check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }



}// end of class
