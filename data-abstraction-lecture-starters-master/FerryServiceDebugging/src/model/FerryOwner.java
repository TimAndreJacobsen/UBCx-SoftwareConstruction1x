package model;

public class FerryOwner extends Passenger{

    Ferry ferry;

    public FerryOwner(String name, Ferry ferry) {
        super(name);
        this.ferry = ferry;
    }
}
