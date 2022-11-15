package Sprint4.Uppgift8;

import Sprint4.Uppgift8.Server.Kompis;

import java.io.Serializable;

public class Response implements Serializable {

    private boolean success;
    private Kompis person;
    private String text;

    public Response(String text){
        this.text = text;
    }

    public Response(boolean success){
        this.success = success;
    }

    public Response(boolean success, Kompis person){
        this.success = success;
        this.person = person;
    }

    public void setPerson(Kompis person){
        this.person = person;
    }

    public Kompis getPerson(){
        return person;
    }

    public String getText(){
       return text;
    }

    public boolean getSuccess(){
        return success;
    }
}