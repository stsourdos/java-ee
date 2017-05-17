package com.tsourdos.tricky_java;

/**
 *
 * @author s.tsourdos
 */
public class StaticInitializers {

    static int a = 1111;

    static {
        a = a-- - --a; // 1111 - 1109 = 2
    }

    {
        a = 5; // not executed at all, since not static initializer
    }

    public static void main(String[] args) {
        System.out.println(a);
        new StaticInitializers().getValue();
    }

    /**
     * Null pointer exception in return statement.
     */
    private int getValue() {
    // return null; // this results in compile time error
        return (true ? null : 0);
    }
}
