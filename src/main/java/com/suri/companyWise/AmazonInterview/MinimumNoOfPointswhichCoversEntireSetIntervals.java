package com.suri.companyWise.AmazonInterview;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given a set of intervals [x,y] where 0 <= x,y  <= 2000 how to find minimum number of points which can cover(i.e. Every interval should contain at least one point in resultant set of points) all intervals?
 *
 * example:
 *
 * Given Set of intervals:
 *     [2,5]
 *     [3,7]
 *     [7,10]
 * then answer should be 2 (minimum number of points required to cover all intervals) as points x=3,x=7 is one solution.
 *
 *
 *
 *
 * You can use a greedy algorithm:
 *
 * Sort all intervals by their end points(in increasing order).
 *
 * Iterate over a sorted array of intervals. When an interval is over, there are two options:
 *
 * It is already covered by some point. Nothing should be done in this case.
 * It is not covered yet. Then the end point of this interval should be inserted into to the resulting set.
 * The resulting set generated by this algorithm is optimal.
 */
public class MinimumNoOfPointswhichCoversEntireSetIntervals {
  public static void main(String[] args) {

  }
}