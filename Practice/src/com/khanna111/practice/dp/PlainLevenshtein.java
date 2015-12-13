package com.khanna111.practice.dp;


/**
 * 
 * @author gkhanna
 *
 */
public class PlainLevenshtein {
	private static char[] str1 = "adcklllkl".toCharArray();
	private static char[] str2 = "abcjfkerjfgggg".toCharArray();

	// private static char[] str1 = "abb".toCharArray();
	// private static char[] str2 = "abcd".toCharArray();

	public static void main(String[] args) {
		System.out.println(new PlainLevenshtein().cost(str1.length, str2.length));
		System.out.println(new PlainLevenshtein().LevenshteinDistance(str1.length, str2.length));
	}

	// my code
	private int cost(int i, int j) {

		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}
		assert i >= 0;
		assert j >= 0;

		int c = 1;
		if (str1[i - 1] == str2[j - 1]) {
			c = 0;
		}
		int ins = cost(i, j - 1) + 1;
		int del = cost(i - 1, j) + 1;
		int sub = cost(i - 1, j - 1) + c;
		return Math.min(ins, Math.min(del, sub));

	}

	// wikipedia code to confirm results
	int LevenshteinDistance(int len_s, int len_t) {
		int cost;

		/* base case: empty strings */
		if (len_s == 0)
			return len_t;
		if (len_t == 0)
			return len_s;

		/* test if last characters of the strings match */
		if (str1[len_s - 1] == str2[len_t - 1])
			cost = 0;
		else
			cost = 1;

		/*
		 * return minimum of delete char from s, delete char from t, and delete
		 * char from both
		 */
		return Math.min(LevenshteinDistance(len_s - 1, len_t) + 1,
				Math.min(LevenshteinDistance(len_s, len_t - 1) + 1, LevenshteinDistance(len_s - 1, len_t - 1) + cost));
	}

}
