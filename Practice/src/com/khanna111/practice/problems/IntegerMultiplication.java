package com.khanna111.practice.problems;

import java.util.Formatter;

/**
 * Basic recursive Integer Multiplication of two n digit numbers.
 * 
 * Does not matter if the number of digits are odd and even. This program
 * reduces the complexity of multiplication of n digits by breaking that into
 * multiplication of numbers with lower number of digits and some addition.
 * 
 * @author gaurav_khanna1
 * 
 *
 */
public class IntegerMultiplication {

    static int x = 20121;
    static int y = 12012;
    static int n = 5;

    public IntegerMultiplication(int x, int y, int n) {
	Formatter f = new Formatter(new StringBuilder());
	System.out.println(f.format("Multipying: x:%d and y: %d", x, y));
	int result = recMult(x, y, n);
	System.out.format("Result is: %d\n", result);
	System.out.println("Another result: " + (x * y));
	f.close();
    }

    private int recMult(int x, int y, int n) {
	if (n == 1) {
	    return x * y;
	}
	else {
	    // ceil this
	    int nBy2 = n / 2 + (n % 2 == 0 ? 0 : 1);
	    int divisor = (int) Math.pow(10, nBy2);
	    int nthPower = (int) Math.pow(10, n);
	    int a = x / divisor;
	    int a0 = x % divisor;
	    int b = y / divisor;
	    int b0 = y % divisor;
	    return nthPower * recMult(a, b, n / 2) + divisor * (recMult(a, b0, nBy2) + recMult(a0, b, n / 2))
		    + recMult(a0, b0, nBy2);
	}
    }

    public static void main(String[] args) {
	new IntegerMultiplication(x, y, n);
    }
}
