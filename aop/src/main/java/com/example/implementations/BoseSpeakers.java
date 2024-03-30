package com.example.implementations;

import com.example.pojo.Song;
import com.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {

    public String makeSound(Song song){
        return "Play song " + song.getTitle() + " by singer "+ song.getSinger() +" using Bose speakers";
    }

}
