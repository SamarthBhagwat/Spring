package com.example.constructor.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name = "Toyota";

    Vehicle(){
        System.out.println("Vehicle bean created by Spring context");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Vehicle name is : "+ this.getName();
    }
}
