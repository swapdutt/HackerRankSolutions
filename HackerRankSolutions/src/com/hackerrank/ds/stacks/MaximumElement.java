package com.hackerrank.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			int query = scn.nextInt();
			switch (query) {
			case 1:
				int x = scn.nextInt();
				stack.push(x);
				if (maxStack.isEmpty() || x >= maxStack.peek()) {
					maxStack.push(x);
				}
				break;
			case 2:
				int popFromStack = stack.pop();
				if (popFromStack == maxStack.peek()) {
					maxStack.pop();
				}
				break;
			case 3:
				System.out.println(maxStack.peek());
			default:
				break;
			}
		}
		scn.close();
	}
}