package com.tsourdos.tricky_java.memory_leak;

/**
 * Instead of using the primitive long for the sum, we use the Long wrapper class. Due to auto-boxing,
 * sum=sum+l; creates a new object in every iteration, so 1000 unnecessary objects will be created.
 *
 * @author s.tsourdos
 */
public class Autoboxing {

    public long addIncremental(long l) {
        Long sum = 0L;
        sum = sum + l;
        return sum;
    }

    public static void main(String[] args) {
        Autoboxing adder = new Autoboxing();
        for (long i = 0; i < 1000; i++) {
            adder.addIncremental(i);
        }
    }
}
