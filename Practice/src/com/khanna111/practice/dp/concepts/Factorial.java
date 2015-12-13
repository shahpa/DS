package com.khanna111.practice.dp.concepts;

/**
 * The factorial problem does not lend itself to DP since there are no
 * overlapping subproblems - we only calculate the factorial for a number once
 * and do not need to calculate again even in that run. It is different from say
 * Fibonacci where different paths require the same value to be calculated
 * again.
 * <p>
 * However, we can still benefit from caching factorials previously calculated
 * in prior runs of the program and they can benefit subsequent invocations. For
 * instance: we can cache the factorials till n = 5 from a prior run and
 * immediately return from the cache any subsequent invocation with n <= 5. But
 * this is not memoization - this is simply caching. Memoization is a useful and
 * is in use when calculating the fibonacci sequence.
 * <p>
 * Similarly MergeSort does not lend itself to DP or memoization since there are
 * no overlapping sub-problems. The keyword being <b>overlapping</b>.
 * 
 * 
 * @author gkhanna
 *
 */
public class Factorial {

	public static void main(String[] args) {

		Factorial f = new Factorial();
		System.out.println("fact1: " + f.fact1(5, 0, 1));
		System.out.println("fact1: " + f.fact1(8, 0, 1));

		System.out.println("fact2: " + f.fact2(5));
		System.out.println("fact2: " + f.fact2(8));

		System.out.println("fact1A: " + f.fact1A(5));
		System.out.println("fact1A: " + f.fact1A(8));

		System.out.println("fact2A: " + f.fact2A(5));
		System.out.println("fact2A: " + f.fact2A(8));
	}

	/**
	 * This calculates factorial bottoms-up but this is no DP or optimal
	 * approach. This is just plain and simple recursion where we start at the
	 * bottom (the leaf) and traverse all the way to the number that we need the
	 * factorial of. We could have started from the number that we need the
	 * factorial of and traversed backwards (top down). That is easier as well.
	 * 
	 * 
	 * @param n
	 *            - we need to calculate the factorial of this number
	 * @param level
	 *            - this is the starting point.
	 * @param soFar
	 *            - this is the carry over of the factorial being calculated
	 * @return
	 */
	int fact1(int n, int level, int soFar) {

		if (level < n) {
			level = level + 1;
			soFar = level * soFar;
			return fact1(n, level, soFar);
		} else
			return soFar;

	}

	/**
	 * This is normal top-down approach where we start from the number we need
	 * the factorial of. This is simply and elegantly put in fewer lines.
	 * 
	 * @param n
	 *            - the number to calculate the factorial of.
	 * @return
	 */
	int fact2(int n) {

		if (n == 1) {
			return 1;
		} else {
			return n * fact2(n - 1);
		}
	}

	/**
	 * Similar to {@link Factorial#fact1(int, int, int)}. The only difference is
	 * that we use iteration. This is also a bottom-up approach.
	 * 
	 * 
	 */
	int fact1A(int n) {

		int soFar = 1;
		for (int i = 1; i <= n; i++) {
			soFar = soFar * i;
		}
		return soFar;
	}

	/**
	 * An iterative top-down approach.
	 * 
	 * 
	 */
	int fact2A(int n) {

		int soFar = n;
		for (int i = n - 1; i >= 1; i--) {
			soFar = soFar * i;
		}
		return soFar;
	}

}
