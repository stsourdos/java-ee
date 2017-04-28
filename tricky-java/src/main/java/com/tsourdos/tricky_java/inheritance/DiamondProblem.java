package com.tsourdos.tricky_java.inheritance;

/**
 * Java does not support multiple inheritance.
 *
 * Case-1: If two super interfaces define methods with the same signature, the compiler will raise an error.
 */
public class DiamondProblem implements DogInterface, CatInterface {

    public static void main(String[] args) {
        new DiamondProblem().noise();
    }

    /**
     * To resolve the conflict we use the super keyword within the DiamondProblem class to explicitly mention
     * which method definition to use
     */
    @Override
    public void noise() {
        DogInterface.super.noise();
    }
}

interface DogInterface {

    default public void noise() {
        System.out.println("Interface1's foo");
    }
}

interface CatInterface {

    default public void noise() {
        System.out.println("Interface2's foo");
    }
}

/**
 * Case-3: If a base class and a base interface define methods with the same signature, the method definition
 * in the class is used and the interface definition is ignored. No compile time error. Class wins rule.
 */
class DiamondProblem2 extends DogClass implements DogInterface {

    public static void main(String[] args) {
        new DiamondProblem2().noise();
    }
}

class DogClass {

    public void noise() {
        System.out.println("BaseClass's foo");
    }
}

/**
 * Case-3: The original - prior to Java 8 Diamond Problem.
 */
abstract class SuperClass {

    public abstract void noise();
}

class Cow extends SuperClass {

    @Override
    public void noise() {
        System.out.println("moooo");
    }
}

class Bird extends SuperClass {

    @Override
    public void noise() {
        System.out.println("tsiou tsiou");
    }
}

/**
 * Compile Time Error
 */
//class Child extends Cow, Bird {
//	public void test(){
//		//calling super class method
//		noise();
//	}
//}
