public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
    }
}