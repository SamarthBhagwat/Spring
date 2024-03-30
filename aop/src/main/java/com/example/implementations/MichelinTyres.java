package com.example.implementations;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres {

    public String rotate(){
        return "Move vehicle using Michelin tyres";
    }
}
