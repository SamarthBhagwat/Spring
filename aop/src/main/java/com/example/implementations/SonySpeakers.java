package com.example.implementations;

import com.example.pojo.Song;
import com.example.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {
    public String makeSound(Song song){
        return "Play song " + song.getTitle() + " by singer "+ song.getSinger() +" using Sony speakers";
    }
}
