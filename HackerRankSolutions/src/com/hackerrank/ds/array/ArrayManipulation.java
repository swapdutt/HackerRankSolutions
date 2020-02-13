package com.hackerrank.ds.array;

import java.io.*;
import java.util.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long max = Integer.MIN_VALUE; // assigning the maximum value and initialized with the minimum value of integer (-2^31)

        long[] aArray = new long[n + 1]; // Initializing a array with n+1 elements

        long[] bArray = new long[n]; // Initializing a array with n elements

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                aArray[0] = bArray[0]; // Assigning the value of bArray with index 0 to aArray with index 0
            } else {
                aArray[i] = bArray[i] - bArray[i - 1]; // Assigning the value to aArray with index more than 0 by calculating the difference of values in bArray 
                										// with index i and (i-1) because the length of aArray is 1 more than the length of bArray
            }

        }

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i]; // Storing the queries array in a temporary array

            /*
             * Assigning the values of queries with indexes 0,1 and 2 in three different temporary integer variables as per the second line of function 
             * description
             */
            int a = q[0];
            int b = q[1];
            int k = q[2];

            update(aArray, a - 1, b - 1, k); // Function to update the array by adding a value to each array element. Here,
            								// k is parameter which will be added, (a-1) and (b-1) are the indices
        }

        /*
         * Assignment of maximum value
         */
        for (int i = 0; i < bArray.length; i++) {
            if (i == 0) {
                bArray[i] = aArray[i];
            } else {
                bArray[i] = aArray[i] + bArray[i - 1];
                if (bArray[i] > max) {
                    max = bArray[i];
                }
            }
        }

        return max;
    }

    private static void update(long[] aArray, int l, int r, int x) {
        aArray[l] += x; // l = (a-1) and x = k

        aArray[r + 1] -= x; // r= (b-1) and x = k

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
