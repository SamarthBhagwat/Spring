package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name for non spring context is: " + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle primaryVehicle = context.getBean(Vehicle.class);
        System.out.println("Primary Vehicle name is : " + primaryVehicle.getName());
        Vehicle vehicle1 = context.getBean("audiVehicle", Vehicle.class);
        System.out.println("Vehicle 1 name is : " + vehicle1.getName());
        Vehicle vehicle2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("Vehicle 2 name is : " + vehicle2.getName());
        Vehicle vehicle3 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println("Vehicle 3 name is : " + vehicle3.getName());


        String hello = context.getBean(String.class);
        System.out.println("String value from Spring context is: "+ hello);
        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from spring context is: "+ num);
    }
}
