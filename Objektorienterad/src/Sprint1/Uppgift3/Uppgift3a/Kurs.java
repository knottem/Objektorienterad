package Sprint1.Uppgift3.Uppgift3a;

public class Kurs {

    protected String namn;
    protected Lärare lärare;
    protected Student[] studenter;
    private int studentCounter = 0;

    Kurs(String namn){
        this.namn = namn;
        studenter = new Student[10];
    }

    public String getNamn(){
        return namn;
    }

    public Lärare getLärare(){
        return lärare;
    }

    public Student[] getStudenter(){
        return studenter;
    }

    public void läggTillStudent(Student student){
        studenter[studentCounter++] = student;
    }

    public void läggTillLärare(Lärare lärare){
        this.lärare = lärare;
    }

    public void taBortLärare(){
        this.lärare = null;
    }
}


