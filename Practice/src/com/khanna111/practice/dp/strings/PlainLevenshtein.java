package com.khanna111.practice.dp.strings;

/**
 * 
 * @author gkhanna
 *
 */
public class PlainLevenshtein {
	private final char[] str1;
	private final char[] str2;

	public PlainLevenshtein(String s1, String s2) {
		str1 = s1.toCharArray();
		str2 = s2.toCharArray();
	}

	// my code 1
	public int cost1(int i, int j) {

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
		int ins = cost1(i, j - 1) + 1;
		int del = cost1(i - 1, j) + 1;
		int sub = cost1(i - 1, j - 1) + c;
		return Math.min(ins, Math.min(del, sub));

	}

	// my code 2
	public int cost2(int i, int j) {

		if (i == str1.length) {
			return str2.length -j;
		}
		if (j == str2.length) {
			return str1.length - i;
		}
		assert i >= 0;
		assert j >= 0;

		int c = 1;
		if (str1[i] == str2[j]) {
			c = 0;
		}
		int ins = cost2(i, j + 1) + 1;
		int del = cost2(i + 1, j) + 1;
		int sub = cost2(i + 1, j + 1) + c;
		return Math.min(ins, Math.min(del, sub));

	}

	// wikipedia code to confirm results
	public int LevenshteinDistance(int len_s, int len_t) {
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
