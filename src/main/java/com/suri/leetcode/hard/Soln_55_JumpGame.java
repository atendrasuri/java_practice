package com.suri.leetcode.hard;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.
 */
public class Soln_55_JumpGame {
  public static void main(String[] args) {

    System.out.println(canJump(new int[]{2,3,1,1,4}));
    System.out.println(canJump(new int[]{3,2,1,0,4}));

  }
  public static boolean canJump(int[] nums) {
    int n = nums.length;
    if(n==1){
      return true;
    }
    if (n == 0 || nums[0] == 0) {
      // end cannot be reached
      return false;
    }

    int i, j;

    int jumps[] = new int[n];
    jumps[0] = 0;

    // Find the minimum number of jumps to reach arr[i]
    // from arr[0], and assign this value to jumps[i]
    for (i = 1; i < n; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (j = 0; j < i; j++) {

        if (j + nums[j] >= i && jumps[j] != Integer.MAX_VALUE) {
          jumps[i] = Math.min(jumps[i], jumps[j] + 1);
          break;
        }
      }
    }
    return jumps[n - 1]!=Integer.MAX_VALUE;
  }
}