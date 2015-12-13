package com.khanna111.test.practice.dp.strings;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.khanna111.practice.dp.strings.DPTabulateLevenshtein;
import com.khanna111.practice.dp.strings.PlainLevenshtein;

public class TestDPTabulateLevenshtein {

	@Test
	public void testCost1_A() {
		String str1 = "adcklllkl";
		String str2 = "abcjfkerjfgggg";
		int cost1 = new DPTabulateLevenshtein().cost1(str1.toCharArray(), str2.toCharArray());
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost1);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost1, 11);
	}

	@Test
	public void testCost1_B() {
		String str1 = "abcjfkerjfgggg";
		String str2 = "adcklllkl";
		int cost1 = new DPTabulateLevenshtein().cost1(str1.toCharArray(), str2.toCharArray());
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost1);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost1, 11);
	}
}
