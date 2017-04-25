package com.tsourdos.tricky_java.inheritance;

/**
 *
 * @author s.tsourdos
 */
public class Inheritance {

    /**
     * Illustrates inherited object creation.
     */
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.whoAmI();
        animal.makeNoise();

        // compile time error: abstract classes cannot be instanciated
        // Dog noWay = new Animal();
        Dog dog = new Dog();
        dog.whoAmI();
        dog.moveYourTail();
    }
}

class Dog extends Animal {

    public Dog() {
        super("a cute dog");
    }

    @Override
    public void makeNoise() {
        System.out.println("Barking...");
    }
    public void moveYourTail() {
        System.out.println("Tail is moving...");
    }
}

abstract class Animal {
    private final String type;

    public Animal(String type) {
        this.type = type;
    }

    public abstract void makeNoise();
    
    public void whoAmI() {
        System.out.println("I am " + type);
    }
}
