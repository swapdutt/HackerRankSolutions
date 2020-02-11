package com.hackerrank.ds.array;

import java.io.*;
import java.util.*;

public class SparseArrays {

	// Complete the matchingStrings function below.
	static void matchingStrings(String[] strings, String[] queries) {

		// Traversing the array of queries
		for (int i = 0; i < queries.length; i++) {
			System.out.println(search(strings, queries[i]) + " ");
		}
	}
	
	/*
	 * Function to match the strings and queries and return the counter
	 */

	private static int search(String[] arr, String s) {
		int counter = 0; // Initializing the counter

		// Traversing the whole array
		for (int j = 0; j < arr.length; j++) {
			// Comparing the queries and strings
			if (s.equals(arr[j])) {
				counter++; // Increasing the count of the counter if both them matched
			}
		}

		return counter; // Returning the count of counter after both them matches
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		matchingStrings(strings, queries);

		/*
		 * for (int i = 0; i < res.length; i++) {
		 * bufferedWriter.write(String.valueOf(res[i]));
		 * 
		 * if (i != res.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

		scanner.close();
	}

}
