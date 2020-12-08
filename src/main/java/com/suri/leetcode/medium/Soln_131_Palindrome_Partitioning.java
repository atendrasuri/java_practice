package com.suri.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Soln_131_Palindrome_Partitioning {
  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.partition("aab"));

  }
}

class Solution {


  List<List<String>> result = new ArrayList<>();

  public List<List<String>> partition(String s) {
    dfs(s, new ArrayList<>());
    return result;
  }

  public void dfs(String s, List<String> current) {

    if (s.length() == 0) {
      result.add(current);
      return;
    }

    for (int i = 1; i <= s.length(); i++) {
      String subString = s.substring(0, i);
      if (isPalindrome(subString)) {
        List<String> newList = new ArrayList<>(current);
        newList.add(subString);
        dfs(s.substring(i, s.length()), newList);
      } else {
        continue;
      }
    }
  }

  public boolean isPalindrome(String s) {
    if (s.length() == 0) {
      return true;
    }
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      r--;
      l++;
    }
    return true;
  }
}