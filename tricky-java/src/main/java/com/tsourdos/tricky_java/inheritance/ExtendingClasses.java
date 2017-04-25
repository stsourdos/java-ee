package com.tsourdos.tricky_java.inheritance;

/**
 *
 * @author s.tsourdos
 */
public class ExtendingClasses {

    /**
     * You cannot override a private or static method in Java.
     */
    public Building getExtendedBuilding() {
        Building building = new Building() {
            @Override
            public void printDoor() {
                System.out.println("Overriden Door");
            }
            // Compile time error
//            @Override
//            public static void printAllWindows() {
//                System.out.println("Overriden Window");
//            }
//            @Override
//            private void printHiddenWindow() {
//                System.out.println("Overriden Hidden Window");
//            }
        };

        return building;
    }
}

class Building {

    public void printDoor() {
        System.out.println("Door here");
    }

    public static void printAllWindows() {
        System.out.println("Window here");
        new Building().printHiddenWindow();
    }

    private void printHiddenWindow() {
        System.out.println("Hidden Window here");
    }
}
