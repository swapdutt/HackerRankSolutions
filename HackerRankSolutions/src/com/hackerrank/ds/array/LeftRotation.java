package com.hackerrank.ds.array;

import java.util.*;

public class LeftRotation {

	private static final Scanner scn = new Scanner(System.in);

	// Function to left rotate by one position in an array
	public static void leftRotateByOne(int[] arr) {

		int first = arr[0]; // Initialized the temporary variable with the value of array at first location
		for (int i = 0; i < (arr.length - 1); i++) {
			arr[i] = arr[i + 1]; // Swapping the elements of the values of the array
		}

		arr[arr.length - 1] = first; // The temporary variable is then assigned to the array location from where the value was swapped

	}

	// Function to left rotate by r position in an array
	private static void leftRotate(int[] arr, int r) {
		for (int i = 0; i < r; i++) {
			leftRotateByOne(arr);
		}

	}

	public static void main(String[] args) {

		int len = scn.nextInt();
		int r = scn.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = scn.nextInt();
		}

		leftRotate(arr, r);

		for (int i = 0; i < len; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
