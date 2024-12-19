public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();
        Vehicle myTruck = new Truck();

        myCar.start();
        myCar.stop();
        ((Car) myCar).honk();

        myBike.start();
        myBike.stop();
        ((Bike) myBike).revEngine();

        myTruck.start();
        myTruck.stop();
        ((Truck) myTruck).loadCargo();
    }
}