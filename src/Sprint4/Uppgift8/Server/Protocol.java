package Sprint4.Uppgift8.Server;

import Sprint4.Uppgift8.Initiator;
import Sprint4.Uppgift8.Response;
import Sprint4.Uppgift8.resources.Kompis;

import java.util.ArrayList;

public class Protocol {

    private static final int BEFORE_INIT = 0;
    private static final int WAITING_FOR_REQUEST = 1;

    private int state = BEFORE_INIT;
    Kompis kompis;
    private ArrayList<Kompis> databas = new Databas().getDatabase();

    public Object processInput(String theInput) {
        Object output = null;

        if(state == BEFORE_INIT){
            output = new Initiator().WelcomeMessage();
            state = WAITING_FOR_REQUEST;
        } else if (state == WAITING_FOR_REQUEST) {
            for (Kompis data : databas) {
                if (data.getName().equalsIgnoreCase(theInput)) {
                    kompis = data;
                }
            }
            if(kompis == null){
                output = new Response(false);
            }
            else{
                output = new Response(true, kompis);
            }

        }
        return output;
    }
}
