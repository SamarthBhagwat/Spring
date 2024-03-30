package com.example.implementations;

import com.example.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgestoneTyres implements Tyres {

    public String rotate(){
        return "Move vehicle using Bridgestone tyres";
    }

}
