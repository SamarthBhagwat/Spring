package com.example.main;

import com.example.config.ProjectConfig;
import com.example.pojo.Song;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Song song = new Song();
        song.setTitle("Ve kamliya");
        song.setSinger("Arijit singh");
        var vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        boolean vehicleStarted = true;
        vehicleServices.playMusic(vehicleStarted, song);
        context.close();
    }
}
