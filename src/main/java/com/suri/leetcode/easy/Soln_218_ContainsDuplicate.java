package com.suri.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 Given an array of integers, find if the array contains any duplicates.

 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

 Example 1:

 Input: [1,2,3,1]
 Output: true
 Example 2:

 Input: [1,2,3,4]
 Output: false
 Example 3:

 Input: [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */
public class Soln_218_ContainsDuplicate {

  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

  }
  public static boolean containsDuplicate(int[] nums) {
    if(nums.length==0){
      return false;
    }

    Set<Integer> set = new HashSet<>();
    for(int a:nums){
      if(set.contains(a)){
        return true;
      }
      set.add(a);
    }
    return false;

  }
}