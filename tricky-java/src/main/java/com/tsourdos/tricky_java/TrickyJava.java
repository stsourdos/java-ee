package com.tsourdos.tricky_java;

/**
 *
 * @author s.tsourdos
 */
public class TrickyJava {

    public static void main(String[] args) {
        System.out.println("result of the assignment expression is: " + assignmentOperationResult());
        System.out.println("result of pre/post increment operations is: " + prePostIncrementOperators());
        System.out.println("Double.MIN_VALUE is equal to: " + getDoubleMinValue());
    }

    /**
     * At run time, the result of the assignment expression is the value of the variable after the assignment
     * has occurred. The result of an assignment expression is not itself a variable.
     *
     * return true
     */
    private static boolean assignmentOperationResult() {
        boolean stop = false;

        if (stop = true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ++i : pre-increment - first perform increment, then use the variable
     * i++ : post-increment - use the variable, then perform increment
     *
     * @return 9
     */
    private static int prePostIncrementOperators() {
        int i = 1;
        int j = 5 + ++i;

        return j + i++;
    }

    /**
     * both the MAX_VALUE and MIN_VALUE of the Double class are positive numbers. The Double.MIN_VALUE is
     * 2^(-1074), which is the closest to 0 double, but not 0.
     *
     * @return 0.0
     */
    private static double getDoubleMinValue() {
        return Math.min(Double.MIN_VALUE, 0.0d);
    }

    /**
     * switch statement possible values: String, char, short, int, enum
     */
    private static void switchStatementValues() {
        String stringObj = "";
        switch(stringObj) {
        }

        char charObj = 'a';
        switch(charObj) {
        }

        short shortObj = 30;
        switch(shortObj) {
        }

        int intObj = 30;
        switch(intObj) {
        }

        SwitchEnum switchEnumObj = SwitchEnum.THAT;
        switch(switchEnumObj) {
        }
    }

    private static enum SwitchEnum {
        THIS, THAT
    }

    /**
     * int + + int = int + int
     * int - - int = int + int
     * @return 33
     */
    private int additionOfIntegers() {
        return 10 + + 11 - - 12;
    }
}
