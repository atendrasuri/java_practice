package com.suri.leetcode.hard;

/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 Example:

 Input: "aab"
 Output: 1
 Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class Soln_132_PalindromePartitioningII {
  public static void main(String[] args) {
    System.out.println(minCut("aaaabbaa"));
    System.out.println(minCut("banana"));

  }
  public static int minCut(String s) {

    int n = s.length();
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];

    for(int i = 0; i < n; i++) {
      int min = i;
      for(int j = 0; j <= i; j++) {
        if(s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
          pal[j][i] = true;
          min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
        }
      }
      cut[i] = min;
    }
    return cut[n - 1];

  }
}