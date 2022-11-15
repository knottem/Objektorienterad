package Sprint4.Uppgift8.Server;

import java.io.Serializable;

public class Kompis implements Serializable {

    private final String name, email;
    private final String phoneNumber;
    private final String dateOfBirth;

    public Kompis(String name, String email, String phoneNumber, String dateOfBirth) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Namn: " + name + "\nEmail: " + email + "\nTfn: " + phoneNumber + "\nFödelsedag: " + dateOfBirth;
    }
}
