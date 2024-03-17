package implementation;

import interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres {

    public String rotate(){
        return "Move vehicle using Michelin tyres";
    }
}
