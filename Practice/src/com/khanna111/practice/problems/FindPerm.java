package com.khanna111.practice.problems;

import java.util.ArrayList;
import java.util.List;

import com.khanna111.util.PrintUtil;

/**
 * This is to find the permutations "+" and "-" interspersed with characters
 * such as [0-9] or [A-B] or any other.
 * 
 * For instance: the permutation of these operators with the set {1,2} is: +1+2
 * +1-2 -1+2 -1-2
 * 
 * This is a permutation of size = 4 where each operator can be at the first or
 * the second position.
 * 
 * 
 * @author gkhanna
 *
 */
public class FindPerm {

    public static void main(String[] args) {
	findPermRecursive("0123", "", new ArrayList<String>());
	findPermIterative("0123", "", new ArrayList<String>());
    }

    static List<String> findPermRecursive(String str, String suf, List<String> sofar) {
	if (suf.length() == 1) {
	    String s1 = "+" + suf;
	    String s2 = "-" + suf;
	    List<String> sList = new ArrayList<>();
	    if (sofar.isEmpty()) {
		sList.add(s1);
		sList.add(s2);
	    }
	    else {

		for (String s : sofar) {
		    sList.add(s1 + s);
		    sList.add(s2 + s);
		}
	    }
	    return sList;
	}
	else {

	    int length = str.length() - 1;
	    for (int i = length; i >= 0; i--) {
		suf = str.substring(i, i + 1);
		sofar = findPermRecursive(str, suf, sofar);
	    }

	}
	System.out.println("Printing result of recursive algo: " );
	PrintUtil.printList(sofar);
	return sofar;
    }

    static List<String> findPermIterative(String str, String suf, List<String> sofar) {
	int length = str.length() - 1;
	for (int i = length; i >= 0; i--) {
	    suf = str.substring(i, i + 1);
	    sofar = createPerm(suf, sofar);
	}
	System.out.println("Printing result of Iterative algo: " );
	PrintUtil.printList(sofar);
	return sofar;
    }

    private static List<String> createPerm(String suf, List<String> sofar) {
	String s1 = "+" + suf;
	String s2 = "-" + suf;
	List<String> sList = new ArrayList<>();
	if (sofar.isEmpty()) {
	    sList.add(s1);
	    sList.add(s2);
	}
	else {

	    for (String s : sofar) {
		sList.add(s1 + s);
		sList.add(s2 + s);
	    }
	}
	return sList;

    }
}
