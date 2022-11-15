package Sprint4.Uppgift8;

import Sprint4.Uppgift8.resources.Kompis;

import java.io.Serializable;

public class Response implements Serializable {

    private boolean success;
    private Kompis kompis;

    public Response(boolean success){
        this.success = success;
    }

    public Response(boolean success, Kompis kompis){
        this.success = success;
        this.kompis = kompis;
    }

    public void setKompis(Kompis kompis){
        this.kompis = kompis;
    }

    public Kompis getKompis(){
        return kompis;
    }


    public boolean getSuccess(){
        return success;
    }
}