package com.tsourdos.tricky_java.memory_leak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author s.tsourdos
 */
public class LeakExamples {

    public static void main(String[] args) {
        String str = "";
        // This will place the string in memory pool from which you cant remove
        str.intern();
    }

    public static void unclosedOpenStreams() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
