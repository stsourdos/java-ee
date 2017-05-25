package com.tsourdos.tricky_java.lambdas;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author s.tsourdos
 */
public class LambdaMath {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T-- > 0) {
            int ch = in.nextInt();
            int num = in.nextInt();
            if (ch == 1) {
                op = ob.is_odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation is_odd() {
        return (a) -> a % 2 != 0;
    }

    public PerformOperation is_palindrome() {
        return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }

    public PerformOperation is_prime() {
        return (a) -> BigInteger.valueOf(a).isProbablePrime(1);
    }
}
