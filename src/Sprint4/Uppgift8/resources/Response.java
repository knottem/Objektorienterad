package Sprint4.Uppgift8.resources;

import java.io.Serializable;

public class Response implements Serializable {

    private final boolean success;
    private Kompis kompis;
    private String string;

    public Response(boolean success, String string){
        this.success = success;
        this.string = string;
    }

    public Response(boolean success, Kompis kompis){
        this.success = success;
        this.kompis = kompis;
    }

    public Kompis getKompis(){
        return kompis;
    }


    public boolean getSuccess(){
        return success;
    }

    public String getString(){
        return string;
    }
}