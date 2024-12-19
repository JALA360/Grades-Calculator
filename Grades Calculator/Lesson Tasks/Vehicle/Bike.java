public class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    public void revEngine() {
        System.out.println("Bike engine is revving.");
    }
}