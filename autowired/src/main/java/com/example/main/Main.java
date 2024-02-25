package com.example.main;

import com.example.constructor.beans.Person;
import com.example.constructor.beans.Vehicle;
import com.example.constructor.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean(Person.class);

        System.out.println("Vehicle name is: "+ vehicle.getName());
        System.out.println("Person name is: " + person.getName());
        System.out.println("Name of vehicle owned by person " + person.getName() + " is : " + person.getVehicle());
    }
}
