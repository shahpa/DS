package com.khanna111.test.practice.dp.strings;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.khanna111.practice.dp.strings.PlainLevenshtein;

public class TestPlainLevenshtein {

//	@Test
	public void testCost1() {
		String str1 = "adcklllkl";
		String str2 = "abcjfkerjfgggg";
		int cost1 = new PlainLevenshtein(str1, str2).cost(str1.length(), str2.length());
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost1);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost1, 11);
	}
	
	@Test
	public void testCost2_A() {
		String str1 = "adcklllkl";
		String str2 = "abcjfkerjfgggg";
		int cost2 = new PlainLevenshtein(str1, str2).cost2(0, 0);
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost2);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost2, 11);
	}
	
	@Test
	public void testCost2_B() {
		String str1 = "abc";
		String str2 = "acc";
		int cost2 = new PlainLevenshtein(str1, str2).cost2(0, 0);
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost2);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost2, costWiki);
	}
	
	@Test
	public void testCost2_C() {
		String str1 = "xyzabc";
		String str2 = "abc";
		int cost2 = new PlainLevenshtein(str1, str2).cost2(0, 0);
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost2);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost2, costWiki);
	}
	
	@Test
	public void testCost2_D() {
		String str1 = "xyzabc";
		String str2 = "abcxyzdef";
		int cost2 = new PlainLevenshtein(str1, str2).cost2(0, 0);
		int costWiki = new PlainLevenshtein(str1, str2).LevenshteinDistance(str1.length(), str2.length());
		System.out.println("cost 1: " +cost2);
		System.out.println("cost Wiki: " +costWiki);
		assertEquals(cost2, costWiki);
	}
	
}
