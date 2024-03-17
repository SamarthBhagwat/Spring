package services;

import interfaces.Speakers;
import interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    @Autowired
    private Speakers speakers;

    @Autowired
    private Tyres tyres;


    public void playMusic(){
        String sound = speakers.makeSound();
        System.out.println(sound);
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
