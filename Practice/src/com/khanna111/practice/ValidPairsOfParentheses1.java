package com.khanna111.practice;


/**
 * Find the valid pair of open and close parenthesis.
 * 
 * For instance: for n = 1: () for n = 2: (()), ()()
 * 
 *
 * @author khanna
 *
 */
public class ValidPairsOfParentheses1 {

    public static void main(String[] args) {

	new ValidPairsOfParentheses1().print(4, 0, "");
    }

    /**
     * We use a Set so as to avoid duplicates.
     * 
     * @param n
     * @return
     */
    public void print(int l, int r, String s) {
	if (l == 0 && r == 0) {
	    print(s);
	}
	if (l > 0) {
	    print(l - 1, r + 1, s + "(");
	}
	if (r > 0) {
	    print(l, r - 1, s + ")");
	}
    }

    private void print(String s) {
	System.out.println(s);
	
    }
}
