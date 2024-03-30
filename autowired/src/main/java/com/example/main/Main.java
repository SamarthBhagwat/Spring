package com.example.main;

//import com.example.constructor.beans.Person;
//import com.example.constructor.beans.Vehicle;
//import com.example.constructor.config.ProjectConfig;
import com.example.field.beans.*;
import com.example.field.config.*;
//import com.example.multiplebeansofsametype.beans.Person;
//import com.example.multiplebeansofsametype.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);

        System.out.println("Person name is: " + person.getName());
        System.out.println("Name of vehicle owned by person " + person.getName() + " is : " + person.getVehicle());
    }
}
