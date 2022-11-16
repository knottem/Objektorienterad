package Sprint4.Uppgift8.Server;

import java.io.Serializable;
public class Initiator implements Serializable{

    public String WelcomeMessage(){
        return "Välkommen till servern \nVilken person vill du söka efter?";
    }

    public String repeatMessage(){
        return "\nVilken person vill du söka efter?";
    }

}