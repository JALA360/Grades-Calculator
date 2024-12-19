public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Bird's Name: " + name);
    }
}