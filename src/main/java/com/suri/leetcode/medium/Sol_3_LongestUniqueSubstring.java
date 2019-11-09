package com.suri.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Sol_3_LongestUniqueSubstring {
  public static void main(String[] args) {

    System.out.println(lengthOfLongestSubstring("abcabcbb"));

  }

  public static int lengthOfLongestSubstring(String s) {


    if (s.length() == 0) {
      return 0;
    }
    char[] str = s.toCharArray();

    int maxLen = 0;
    int currLen = 0;
    int startIndex = 0;
    int endIndex = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (endIndex < str.length) {

      if (map.get(str[endIndex]) != null && map.get(str[endIndex]) >= startIndex) {

        startIndex = map.get(str[endIndex]) + 1;
      } else {
        currLen = endIndex - startIndex + 1;


        if (currLen > maxLen) {

          maxLen = currLen;
        }
      }
      map.put(str[endIndex], endIndex);
      endIndex = endIndex + 1;
    }
    return maxLen;
  }
}