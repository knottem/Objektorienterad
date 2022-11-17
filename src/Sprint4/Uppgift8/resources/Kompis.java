package Sprint4.Uppgift8.resources;

import java.io.Serializable;

public class Kompis implements Serializable {

    private final String name, email;
    private final String phoneNumber;
    private final String dateOfBirth;
    private final String adress;

    public Kompis(String name,String adress, String email, String phoneNumber, String dateOfBirth) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAdress(){
        return adress;
    }

    @Override
    public String toString() {
        return "Namn: " + name + "\nAdress: " + adress + "\nEmail: " + email + "\nTfn: " + phoneNumber + "\nFödelsedag: " + dateOfBirth;
    }
}
