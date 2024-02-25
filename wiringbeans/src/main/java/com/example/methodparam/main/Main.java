package com.example.methodparam.main;

import com.example.methodparam.beans.Person;
import com.example.methodparam.beans.Vehicle;
import com.example.methodparam.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean(Person.class);

        System.out.println("Vehicle name is: " + vehicle.getName());
        System.out.println("Person name is : " + person.getName());
        System.out.println("Vehicle owned by person is: " + person.getVehicle());
    }
}
