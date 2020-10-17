package com.hackerrank.ds.queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			int operationNumber = scn.nextInt();
			if (operationNumber == 1) {
				queue.enqueue(scn.nextInt());
			} else if (operationNumber == 2) {
				queue.dequeue();
			} else if (operationNumber == 3) {
				System.out.println(queue.peek());
			}
		}
		scn.close();
	}

	@SuppressWarnings("hiding")
	public static class MyQueue<Integer> {
		private Stack<Integer> stack1 = new Stack<Integer>();
		private Stack<Integer> stack2 = new Stack<Integer>();

		public void enqueue(Integer number) {
			stack1.push(number);
		}

		public Integer dequeue() {
			if (stack1.size() + stack2.size() == 0) {
				return null;
			}
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}

		public Integer peek() {
			if (stack1.size() + stack2.size() == 0) {
				return null;
			}
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.peek();
		}
	}
}