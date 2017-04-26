# Tricky Java

Contains commonly encountered tricky behavior of Java Programming language, during development but also in interviews.

## Commons

#### Assignment Operation Result

At run time, the result of the assignment expression is the value of the variable after the assignment
has occurred. The result of an assignment expression is not itself a variable.
```
boolean stop = false;
// indeed this will always be true
if (stop = true) {
    return true;
} else {
    return false;
}
```

#### Pre/Post Increment Operators

```
++i // pre-increment - first perform increment, then use the variable
i++ // post-increment - use the variable, then perform increment
```

#### Double Min value

both the MAX_VALUE and MIN_VALUE of the Double class are positive numbers. The Double.MIN_VALUE is 2^(-1074), which is the closest to 0 double, but not 0.
```
Math.min(Double.MIN_VALUE, 0.0d); // always 0.0
```

#### Switch Statement value
A switch works with the byte, short, char, and int primitive data types. It also works with enumerated types, the String class and a few special classes that wrap certain primitive types: Character, Byte, Short, and Integer


#### Array Initialization

All the below are valid:
```
int[] data = {10, 20, 30, 40, 50, 60, 71, 80, 90, 91};

int[] data1;
data1 = new int[]{10, 20, 30, 40, 50, 60, 71, 80, 90, 91};

// an int array with 10 cells allocated
int data2[] = new int[10];

int data3[] = new int[]{10, 20, 30, 40, 50, 60, 71, 80, 90, 91};

/**
 * 2-D array like so:
 * 1 2 3
 * 4 5 6
 */
int[] data4[];
data4 = new int[][]{{1, 2, 3}, {4, 5, 6}};
```

## Inheritance

#### When extending a class

You cannot override a private or static method in Java.
```
public Building getExtendedBuilding() {
  Building building = new Building() {

    // Compile time error
    @Override
    public static void printAllWindows() {
        System.out.println("Overriden Window");
    }
    // Compile time error
    @Override
    private void printHiddenWindow() {
        System.out.println("Overriden Hidden Window");
    }

  };
}
class Building {
  public static void printAllWindows() {
    System.out.println("Window here");
    new Building().printHiddenWindow();
  }
  private void printHiddenWindow() {
    System.out.println("Hidden Window here");
  }
}
```

#### When instansiating

An abstract class / interface cannot be instanciated.
