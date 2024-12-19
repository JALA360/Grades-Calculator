public class Main {
    public static void main(String[] args) {
        // Create an array of Animal objects
        Animal[] animals = new Animal[3];
        
        animals[0] = new Dog("Buddy");
        animals[1] = new Cat("Whiskers");
        animals[2] = new Bird("Tweety");

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}