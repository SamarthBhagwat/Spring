package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }

    @Bean
    Vehicle vehicle1(){
        var vehicle1 = new Vehicle();
        vehicle1.setName("Audi");
        return vehicle1;
    }

    @Bean
    Vehicle vehicle2(){
        var vehicle2 = new Vehicle();
        vehicle2.setName("Honda");
        return vehicle2;
    }

    @Bean
    Vehicle vehicle3(){
        var vehicle3 = new Vehicle();
        vehicle3.setName("Ferrari");
        return vehicle3;
    }
    @Bean
    String hello(){
        return "Hello world";
    }

    @Bean
    Integer number(){
        return 16;
    }

}
