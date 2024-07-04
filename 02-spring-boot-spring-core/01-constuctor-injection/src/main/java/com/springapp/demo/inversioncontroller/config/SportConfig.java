package com.springapp.demo.inversioncontroller.config;

import com.springapp.demo.inversioncontroller.common.Coach;
import com.springapp.demo.inversioncontroller.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
