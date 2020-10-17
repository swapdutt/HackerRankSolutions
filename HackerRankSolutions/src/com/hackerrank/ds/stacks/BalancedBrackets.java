package com.hackerrank.ds.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				try {
					char t = stack.pop();
					if (t != '(') {
						return "NO";
					}
				} catch (EmptyStackException e) {
					// TODO: handle exception
					return "NO";
				}
			} else if (c == '}') {
				try {
					char t = stack.pop();
					if (t != '{') {
						return "NO";
					}
				} catch (EmptyStackException e) {
					// TODO: handle exception
					return "NO";
				}
			} else if (c == ']') {
				try {
					char t = stack.pop();
					if (t != '[') {
						return "NO";
					}
				} catch (EmptyStackException e) {
					// TODO: handle exception
					return "NO";
				}
			}
		}
		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}