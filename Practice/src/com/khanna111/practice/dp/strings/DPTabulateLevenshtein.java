package com.khanna111.practice.dp.strings;

/**
 * 
 * @author gkhanna
 *
 */
public class DPTabulateLevenshtein {
	/**
	 * A little different: we convert s2 into s1.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int cost1(char[] s1, char[] s2) {
		int lenS1 = s1.length;
		int lenS2 = s2.length;
		
		// we convert s2 into s1.
		int[][] cost = new int[lenS1][lenS2];
		
		for (int i = 0; i < lenS1; i++) {
			cost[i][0] = i;
		}
		
		for (int j = 0; j < lenS2; j++) {
			cost[0][j] = j;
		}
		
		// now we begin
		for (int i = 1; i < lenS1; i++) {
			for (int j = 1; j < lenS2; j++) {
				if (s1[i] == s2[j]) {
					// whatever the cost was for the previous indices
					cost[i][j] = cost[i-1][j-1];
				}
				else {
					int costIns = cost[i-1][j] + 1;
					int costDel = cost[i][j-1] + 1;
					int costSub = cost[i-1][j-1] + 1;
					cost[i][j] = Math.min(costIns, Math.min(costDel, costSub));
				}
			}
		}
		return cost[lenS1 - 1][lenS2 -1];
	}
 
}
