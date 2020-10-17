package com.hackerrank.ds.stacks;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks {

	/*
	 * Complete the twoStacks function below.
	 */
	static int twoStacks(int x, int[] a, int[] b) {
		/*
		 * Write your code here.
		 */
/*
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();

		for (Integer i1 : a) {
			s1.push(i1);
		}
		for (Integer i2 : b) {
			s2.push(i2);
		}
		// System.out.println("S1: " + s1);
		// System.out.println("S2: " + s2);

		Collections.reverse(s1);
		Collections.reverse(s2);

		while (s1.peek() + s2.peek() < x) {
			int c = s1.pop();
			int d = s2.pop();
			// System.out.println("C is: " + c);
			// System.out.println("D is: " + d);
			s3.push(c);
			s3.push(d);
		}

		// System.out.println("S3 is: " + s3);
*/		
		int sum = 0;
		int temp = 0;
		int c = 0;
		int i = 0;
		int j = 0;
		
		int n = a.length;
		int m = b.length;
		
		while(i < n && sum + a[i] <= x) {
			sum += a[i];
			i++;
		}
		c = i;
		
		while(j < m && i >= 0) {
			sum += b[j];
			j++;
			while(sum > x && i < 0) {
				i--;
				sum -= a[i];
			}
			if(sum <= x && i+j > c) {
				c = i+ j;
			}
		}

		return c;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int g = Integer.parseInt(scanner.nextLine().trim());

		for (int gItr = 0; gItr < g; gItr++) {
			String[] nmx = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmx[0].trim());

			int m = Integer.parseInt(nmx[1].trim());

			int x = Integer.parseInt(nmx[2].trim());

			int[] a = new int[n];

			String[] aItems = scanner.nextLine().split(" ");

			for (int aItr = 0; aItr < n; aItr++) {
				int aItem = Integer.parseInt(aItems[aItr].trim());
				a[aItr] = aItem;
			}

			int[] b = new int[m];

			String[] bItems = scanner.nextLine().split(" ");

			for (int bItr = 0; bItr < m; bItr++) {
				int bItem = Integer.parseInt(bItems[bItr].trim());
				b[bItr] = bItem;
			}

			int result = twoStacks(x, a, b);

			System.out.println(result);

			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();
	}
}