package Sprint1.Uppgift1;

public class Car {

    private String regnr;
    private String model;
    private String märke;
    CarOwner owner;


    @Override
    public String toString() {
        return märke + " " + model + " " + regnr;
    }

    public Car(String regnr, String model, String märke) {
        this.regnr = regnr;
        this.model = model;
        this.märke = märke;
    }

    public String getRegnr() {
        return regnr;
    }

    public String getModel() {
        return model;
    }

    public String getMärke() {
        return märke;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public CarOwner newOwner(CarOwner owner){
        this.owner = owner;
        return owner;
    }
    public void soldCar(){
        this.owner = null;
    }

}
