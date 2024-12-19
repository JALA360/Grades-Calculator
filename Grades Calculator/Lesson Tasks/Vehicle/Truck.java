public class Truck extends Vehicle {
    @Override
    public void start() {
        System.out.println("Truck is starting with a key.");
    }

    public void loadCargo() {
        System.out.println("Truck is loading cargo.");
    }
}