package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.pojo.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    @Autowired
    private Speakers speakers;

    @Autowired
    private Tyres tyres;


    public void playMusic(boolean vehicleStarted, Song song){
        throw new NullPointerException("Damn!! Null pointer exception occurred");
//        String sound = speakers.makeSound(song);
//        System.out.println(sound);
    }

    public void moveVehicle(){
        String rotate = tyres.rotate();
        System.out.println(rotate);
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
