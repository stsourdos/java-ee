package com.tsourdos.tricky_java;

/**
 *
 * @author s.tsourdos
 */
public class InnerClasses {

    public static void main(String[] args) {

        /**
         * You can only use static variables in static or top-level classes. Here, a static variable
         * in a class that isn't top-level.
         */
        final class Constants {
            // Compile time error
            // public static String name = "PI";
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                // System.out.println(Constants.name);
            }

        });

        thread.start();
    }
}
