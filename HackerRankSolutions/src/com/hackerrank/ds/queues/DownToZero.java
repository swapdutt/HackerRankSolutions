package com.hackerrank.ds.queues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class DownToZero {

	static int downToZero(int n) {
		/*
		 * Write your code here.
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(n);
		map.put(n, 0);
		while (!queue.isEmpty() && !map.containsKey(0)) {
			int num = queue.poll();
			int step = map.get(num);
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0 && num / i != 1) {
					if (!map.containsKey(num / i) || map.get(num / i) > step + 1) {
						map.put(num / i, step + 1);
						queue.add(num / i);
					}
				}
			}
			if (!map.containsKey(num - 1) || map.get(num - 1) > step + 1) {
				queue.add(num - 1);
				map.put(num - 1, step + 1);
			}
		}
		return map.get(0);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(scanner.nextLine().trim());

		for (int qItr = 0; qItr < q; qItr++) {
			int n = Integer.parseInt(scanner.nextLine().trim());

			int result = downToZero(n);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}