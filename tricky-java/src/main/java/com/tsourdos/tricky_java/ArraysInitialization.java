package com.tsourdos.tricky_java;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author s.tsourdos
 */
public class ArraysInitialization {

    public void initializeSampleArrays() {

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
    }
}
