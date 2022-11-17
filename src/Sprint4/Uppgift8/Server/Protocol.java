package Sprint4.Uppgift8.Server;

import Sprint4.Uppgift8.resources.Kompis;
import Sprint4.Uppgift8.resources.Response;

import java.util.ArrayList;

public class Protocol {

    private static final int FIRST_INIT = 0;
    private static final int REPEAT_REQUEST = 1;
    private static final int WAITING_FOR_REQUEST = 2;


    private int state = FIRST_INIT;
    Kompis kompis;
    private final ArrayList<Kompis> databas = new Databas().getDatabase();
    Initiator initiator = new Initiator();

    public Object processInput(String theInput) {
        Object output = null;

        if(state == FIRST_INIT) {
            output = initiator.welcomeMessage();
            state = WAITING_FOR_REQUEST;
        } else if (state == REPEAT_REQUEST) {
            output = initiator.repeatMessage();
            state = WAITING_FOR_REQUEST;
        } else if (state == WAITING_FOR_REQUEST) {
            for (Kompis data : databas) {
                if (data.getName().equalsIgnoreCase(theInput)) {
                    kompis = data;
                } else if(data.getEmail().equalsIgnoreCase(theInput)){
                    kompis = data;
                } else if(data.getPhoneNumber().equalsIgnoreCase(theInput)){
                    kompis = data;
                } else if (data.getAdress().equalsIgnoreCase(theInput)) {
                    kompis = data;
                }
            }
            if(kompis == null){
                output = new Response(false, theInput);
                state = REPEAT_REQUEST;
            } else {
                output = new Response(true, kompis);
                state = REPEAT_REQUEST;
                kompis = null;
            }

        }
        return output;
    }
}
