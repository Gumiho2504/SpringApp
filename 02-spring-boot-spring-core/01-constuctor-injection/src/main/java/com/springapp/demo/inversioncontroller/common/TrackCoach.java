package com.springapp.demo.inversioncontroller.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In Constuctor: " + getClass().getSimpleName());
    }

//    //define our init method
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
//    }
//    // define our destroy method
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
//    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K ";
    }
}
