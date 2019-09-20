package com.suri.problemsolving.stringBased;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LongestUniqueSubstring {

    public static void main(String[] args) {
        //String str = "aaabcbdeaf";
        String str = "GEEKSFORGEEKS";
        String str1 = "ABCA";

        System.out.println("" + getLongestUniqueSubstring(str1));

        System.out.println(""+lengthOfLongestSubstring(str1));
    }


    public static int getLongestUniqueSubstring(String str) {

        char[] str1 = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        int start_index = 0;
        int end_index = 0;
        int curr_len;
        int max_len = 0;

        while (end_index < str1.length) {

            if ((map.get(str1[end_index]) != null) && (map.get(str1[end_index]) >= start_index)) {
                start_index = 1+start_index + map.get(str1[end_index]);
               // map.put(str1[end_index], end_index);
            } else {
               // map.put(str1[end_index], end_index);
                curr_len = end_index - start_index + 1;
                if (curr_len > max_len) {
                    max_len = curr_len;
                }


            }
            map.put(str1[end_index], end_index);
            end_index = end_index + 1;
        }

       // System.out.println("start index "+ start_index);
       // System.out.println("End index "+end_index);
        return max_len;
    }

    public static String lengthOfLongestSubstring(String str) {
        String longestOverall = "";
        String currLongest = "";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                i = map.get(c);
                    if (currLongest.length() > longestOverall.length()) {
                        longestOverall = currLongest;
                    }
                map.clear();
                currLongest = "";
            } else {
                currLongest += c;
                map.put(c, i);
            }
        }
        return longestOverall;
    }
}