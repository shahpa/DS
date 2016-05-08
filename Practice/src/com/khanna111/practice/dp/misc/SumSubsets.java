package com.khanna111.practice.dp.misc;

import java.util.ArrayList;
import java.util.List;

public class SumSubsets {

    static int a[] = { 1, 2, 3, 4, 5, 6 };
    static int b[] = { 2, 5, 1, 8, 9, 11, 3 };

    public static void main(String[] args) {
	SumSubsets instance = new SumSubsets();
	instance.naive(5, 0, 0, new ArrayList<Integer>());
	print("----End");
//	instance.naive(7, 0, 0, new ArrayList<Integer>());
//	print("----End");
//	instance.naive(0, 0, 0, new ArrayList<Integer>());
//	print("----End");
    }

    /**
     * This will only check if any
     * @param sum
     * @param standingSum
     * @param i
     */
    private void naive(int sum, int standingSum, int i, List<Integer> numbers) {

	if (i >= a.length) {
	    // reached end.
	    return;
	}
	
	int s = standingSum + a[i];
	if (s ==  sum) {
	    print ("sum found");
	    for (int j : numbers) {
		print ("" +j);
	    }
	}
	else if (s > sum) {
	    naive(sum, standingSum, ++i, numbers );
	}
	else {
	    numbers.add(a[i]);
	    naive(sum, s, ++i, numbers);
	} 
	
    }

    private static void print(String s) {
	System.out.println(s);
    }
}
