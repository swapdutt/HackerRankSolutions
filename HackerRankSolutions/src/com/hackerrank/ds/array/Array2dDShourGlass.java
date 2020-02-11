package com.hackerrank.ds.array;

import java.io.*;
import java.util.*;

public class Array2dDShourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr, int row, int col) {
        int sum = 0; // Initializing the sum of hour glass
        
        /*
         * Initializing the hour glass 1st and 2nd row and same column or column + 1
         */
        int firstRow = row +1;
        int firstCol = col;
        
        int secondRow = row +1;
        int secondCol = col +2; // 2 is added because the middle element of the hour glass will be shrinked
        
        for(int i = row; i < (row+3); i++){
        	for(int j = col; j < (col + 3); j++){
        		// 3 is added in the row/column because of the shape of hour glass (Hour glass here refers to the sand hour glass that was being used in ancient times) 
        		if((i == firstRow && j ==firstCol) || (i == secondRow && j == secondCol)){
        			continue;
        		}else{
        			sum += arr[i][j]; 
        		}
        	}
        }
        return sum;

    }

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int arr[][] = new int[6][6]; // Already mentioned in problem statement that it is 6X6 array

        int invlaidEntryFlag = 0;
        int max_hour_sum = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scn.nextInt();
                if (arr[i][j] < -9 || arr[i][j] > 9) {
                    invlaidEntryFlag = 1;
                }
            }
        }

        if (invlaidEntryFlag == 0) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    int newSum = hourglassSum(arr, i, j);
                    if (max_hour_sum == 0 && invlaidEntryFlag == 0) {
                        max_hour_sum += newSum;
                        invlaidEntryFlag = 1;
                    } else if (max_hour_sum < newSum) {
                        max_hour_sum = newSum;
                    }
                }
            }
        }

        System.out.println("" + max_hour_sum);
    }
}
