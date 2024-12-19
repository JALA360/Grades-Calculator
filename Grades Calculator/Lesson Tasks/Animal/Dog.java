public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Dog's Name: " + name);
    }
}