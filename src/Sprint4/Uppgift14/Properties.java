package Sprint4.Uppgift14;

import java.io.FileInputStream;

public class Properties {

    java.util.Properties p = new java.util.Properties();
    int rounds;
    int questions;
    public void applySettings(){
        try{
            p.loadFromXML(new FileInputStream("Objektorienterad/src/Sprint4/Uppgift14/properties.xml"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        rounds = Integer.parseInt(p.getProperty("rounds"));
        questions = Integer.parseInt((p.getProperty("questions")));
    }
}
