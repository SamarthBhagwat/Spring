package com.example.prototype.main;

import com.example.prototype.beans.VehicleServices;
import com.example.prototype.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        VehicleServices vs1 = context.getBean(VehicleServices.class);
        VehicleServices vs2 = context.getBean("vehicleServices", VehicleServices.class);

        System.out.println("Hashcode of vs1 : " + vs1.hashCode());
        System.out.println("Hashcode of vs2 : " + vs2.hashCode());

        if(vs1 == vs2){
            System.out.println("Both bean instances are same");
        }
    }
}
