public class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting with a key.");
    }

    public void honk() {
        System.out.println("Car is honking.");
    }
}