package Sprint4.Uppgift6;

public class Kompis {

    private final String name, email;
    private int phoneNumber;
    private long dateOfBirth;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Namn: " + name + "\nEmail: " + email + "\nTfn: " + phoneNumber + "\nFödelsedag: " + dateOfBirth;
    }
}
