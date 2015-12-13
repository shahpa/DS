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

	/**
	 * my code 1: A top-down approach that can benefit from memoization. It
	 * recurses and creates a matrix where the answer lies at [m][n]
	 * <p>
	 * The goal is to transmute "str1" into "str2".
	 * <p>
	 * The initial call is {@code cost1(m, n)} where m = size of "str1" <br>
	 * and n = size of "str2".
	 *
	 * @param i
	 *            the index (the 0th based index from 0 to m - 1)
	 * @param j
	 *            the index (the 0th based index from 0 n - 1)
	 * @return: the final cost
	 */
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

	/**
	 * my code 2: The difference is that this recurses and builds a matrix and
	 * the answer lies at [0][0]. This could also benefit from memoization as
	 * well.
	 * 
	 * <p>
	 * However in order for it to qualify as DP, they key is to solve the
	 * smaller sub-problems first and then move on to solver bigger sub-problems
	 * with the results of the smaller sub-problems that are already computed
	 * and available at that point. Therefore this is not DP either.
	 * <p>
	 * The initial call is cost2(0,0)
	 * 
	 * @param i
	 *            the index (the 0th based index from 0 to m - 1)
	 * @param j
	 *            the index (the 0th based index from 0 n - 1)
	 * @return: the final cost
	 */
	public int cost2(int i, int j) {

		if (i == str1.length) {
			return str2.length - j;
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
