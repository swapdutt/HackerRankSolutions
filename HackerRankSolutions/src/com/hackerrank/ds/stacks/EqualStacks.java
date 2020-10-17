package com.hackerrank.ds.stacks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EqualStacks {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n1 = Integer.parseInt(firstMultipleInput[0]);

		int n2 = Integer.parseInt(firstMultipleInput[1]);

		int n3 = Integer.parseInt(firstMultipleInput[2]);

		String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> h1 = new ArrayList<>();

		for (int i = 0; i < n1; i++) {
			int h1Item = Integer.parseInt(h1Temp[i]);
			h1.add(h1Item);
		}

		String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> h2 = new ArrayList<>();

		for (int i = 0; i < n2; i++) {
			int h2Item = Integer.parseInt(h2Temp[i]);
			h2.add(h2Item);
		}

		String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> h3 = new ArrayList<>();

		for (int i = 0; i < n3; i++) {
			int h3Item = Integer.parseInt(h3Temp[i]);
			h3.add(h3Item);
		}

		int result = Result.equalStacks(h1, h2, h3);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

class Result {

	/*
	 * Complete the 'equalStacks' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY h1 2. INTEGER_ARRAY h2 3. INTEGER_ARRAY h3
	 */

	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		// Write your code here
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();

		int ha1 = 0;
		int ha2 = 0;
		int ha3 = 0;

		int n1 = h1.size();
		int n2 = h2.size();
		int n3 = h3.size();

		Collections.reverse(h1);
		Collections.reverse(h2);
		Collections.reverse(h3);

		for (int i = 0; i < n1; i++) {
			ha1 += h1.get(i);
			s1.push(ha1);
		}
		for (int i = 0; i < 2; i++) {
			ha2 += h2.get(i);
			s2.push(ha2);
		}
		for (int i = 0; i < n3; i++) {
			ha3 += h3.get(i);
			s3.push(ha3);
		}

		Collections.reverse(s1);
		Collections.reverse(s2);
		Collections.reverse(s3);

		int output = 0;

		if (n1 <= n2 && n1 <= n3) {
			for (int i = 0; i < n1; i++) {
				if (s2.indexOf(s1.get(i)) != -1 && s3.indexOf(s1.get(i)) != -1) {
					output = s1.get(i);
					break;
				}
			}
		} else if (n2 <= n1 && n2 <= n3) {
			for (int i = 0; i < n2; i++) {
				if (s1.indexOf(s2.get(i)) != -1 && s3.indexOf(s2.get(i)) != -1) {
					output = s2.get(i);
					break;
				}
			}
		} else if (n3 <= n1 && n3 <= n2) {
			for (int i = 0; i < n3; i++) {
				if (s1.indexOf(s3.get(i)) != -1 && s2.indexOf(s3.get(i)) != -1) {
					output = s3.get(i);
					break;
				}
			}
		}
		return output;
	}
}