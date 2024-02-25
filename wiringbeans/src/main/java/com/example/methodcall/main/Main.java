package com.example.methodcall.beans.main;

import com.example.methodcall.beans.Person;
import com.example.methodcall.beans.Vehicle;
import com.example.methodcall.beans.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean(Person.class);
        System.out.println("Name of vehicle inside spring context: " + vehicle.getName());
        System.out.println("Name of person inside spring context: " + person.getName());
        System.out.println("Name of vehicle of " + person.getName() + " inside spring context : " + person.getVehicle().getName());
    }
}
