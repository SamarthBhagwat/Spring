package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Based on condition, we need to create the corresponding bean
        Random random = new Random();
        int number = random.nextInt(10);
        System.out.println("Random number generated is : " + number);

        Supplier<Vehicle> volkswagenSupplier = () -> {
          Vehicle volkswagenVehicle = new Vehicle();
          volkswagenVehicle.setName("Volkswagen");
          return volkswagenVehicle;
        };

        Supplier<Vehicle> audiSupplier = () -> {
          Vehicle audiVehicle = new Vehicle();
          audiVehicle.setName("Audi");
          return audiVehicle;
        };

        if(number % 2 == 0){
            // number is even
            context.registerBean("Volkswagen", Vehicle.class, volkswagenSupplier);
        }
        else{
            // number is odd
            context.registerBean("Audi", Vehicle.class, audiSupplier);
        }

        System.out.println("Bean created successfully");
        // Till this point, bean is created successfully based on condition
        // get the bean
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Bean of class Vehicle created and name of bean is: "+ vehicle.getName());

        context.close();


        // Creating context using xml config
        var xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle xmlVehicle = xmlContext.getBean(Vehicle.class);
        System.out.println("Name of the bean in xml context is: " + xmlVehicle.getName());

        xmlContext.close();
    }
}
