package com.hackerrank.ds.array;

import java.util.*;

public class DynamicArray {
	
	public static int lastAnswer = 0; // Initializing the value of last answer
	
    public static void main(String[] args)  {
       Scanner scn = new Scanner(System.in);
       
       int n = scn.nextInt(); // Count of empty sequences
       int q = scn.nextInt(); // Count of queries
    		   
    	ArrayList[] arrList = new ArrayList[n]; // Initializing the array list for sequence list
    	
    	for(int i =0; i < n; i++){
    		arrList[i] = new ArrayList<Integer>();
    	}
    	
    	for(int j = 0; j < q; j++){
    		int qType = scn.nextInt();
    		int x = scn.nextInt();
    		int y = scn.nextInt();
    		
    		int seqIndex = ((x ^ lastAnswer) % n); // Finding the sequence index
    		
    		if(qType == 1){
    			arrList[seqIndex].add(y); // Logic when query type of 1 is entered, then the problem statement of query 1 will be solved
    		}else if(qType == 2){
    			/*
    			 * Logic when query type of 2 is entered, then the problem statement of query 2 will be solved
    			 */
    			
    			ArrayList<Integer> seq = arrList[seqIndex];
    			int size = seq.size();
    			
    			int tempIndex = y % size;
    			
    			lastAnswer = seq.get(tempIndex);
    			
    			System.out.println(lastAnswer);
    		}
    	}
    }
}
