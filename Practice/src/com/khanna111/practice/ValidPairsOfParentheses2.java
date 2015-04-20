package com.khanna111.practice;

/**
 * Find the valid pair of open and close parenthesis.
 * 
 * For instance: for n = 1: () for n = 2: (()), ()()
 * 
 * First write down plainly what we need to do in a declarative manner: <code>
 * if (leftRemaining > 0) 
 * then
 * 	choice 1: print "(", leftRemaining--
 * 	choice 2:	if (leftRemaining < rightRemaining)
 * 			then
 * 				print ")", rightRemaining--
 * 			endif
 * 	choice 3:	if (leftRemaining > rightRemaining)
 * 			then
 * 				we do nothing since it is covered by choice 1.
 * 			endif
 * endif
 * else if (rightRemaining > 0 ) 
 * then
 * 	print ")", rightRemaining--
 * endif
 * 
 * </code>
 * 
 * @author khanna
 *
 */
public class ValidPairsOfParentheses2 {

    public static void main(String[] args) {

	new ValidPairsOfParentheses2().print(4, 4, "");
    }

    /**
     * 
     * @param n
     * @return
     */
    public void print(int leftRemaining, int rightRemaining, String s) {
	if (rightRemaining == 0) {
	    print(s);
	    return;
	}
	if (leftRemaining > 0) {
	    print(leftRemaining - 1, rightRemaining, s+"(");
	    if (leftRemaining < rightRemaining) {
		print(leftRemaining, rightRemaining -1 , s +")");
	    }
	}
	else if (rightRemaining > 0) {
	    print(leftRemaining, rightRemaining -1 , s +")");
	}
	
    }

    private void print(String s) {
	System.out.println(s);

    }
}
