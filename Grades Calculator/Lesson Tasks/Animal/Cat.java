public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Cat's Name: " + name);
    }
}