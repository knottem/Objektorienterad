package Sprint4.Uppgift5TCP;

public class Kompis {

    private final String name, email;
    private final int phoneNumber;
    private final long dateOfBirth;

    public Kompis(String name, String email, int phoneNumber, long dateOfBirth) {
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
    public int getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Namn: " + name + "\nEmail: " + email + "\nTfn: " + phoneNumber + "\nFödelsedag: " + dateOfBirth;
    }
}
