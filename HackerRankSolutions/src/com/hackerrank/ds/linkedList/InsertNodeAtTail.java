package com.hackerrank.ds.linkedList;

import java.io.*;
import java.util.*;


public class InsertNodeAtTail {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;

		public SinglyLinkedList() {
			this.head = null;
		}

	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the insertNodeAtTail function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		/*
		 * Checking the head is null
		 * If yes, then insert the nodes at this head
		 * to complete the linked list
		 */
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			head.data = data;
		} else {
			SinglyLinkedListNode slln = head; // Referring the linked list to the head
			/*
			 * Checking the reference address is not null If it is not null, the
			 * value inserted in the linked list will refer to the address of
			 * the previous node. If it is null, then the new node will refer
			 * it's address to the tail of the list
			 */
			while (slln.next != null) {
				slln = slln.next;
			}
			slln.next = new SinglyLinkedListNode(data);
			slln.next.data = data;
		}
		return head;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

			llist.head = llist_head;
		}

		printSinglyLinkedList(llist.head, "\n", bufferedWriter);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
