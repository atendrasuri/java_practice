package com.suri.datastructure.arrays.singledimension.sortedAndRotated;
/* Problem Name is &&& Median Two Sorted Arrays &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Find the median of the two sorted arrays.
 *
 * /**
 *  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *  *
 *  * Solution
 *  * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 *  * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 *  * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *  *
 *  * Time complexity is O(log(min(x,y))
 *  * Space complexity is O(1)
 *  *
 *  * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *  * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 *  */



public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] input1, int[] input2) {

        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            int partitionX = (low + high) / 2;

            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxleftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minrightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];


            int maxleftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minrightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];


            if (maxleftX <= minrightY && maxleftY <= minrightX) {


                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxleftX, maxleftY) + Math.min(minrightX, minrightY)) / 2;
                } else {
                    return (double) Math.max(maxleftX, maxleftY);
                }
            } else if (maxleftX > minrightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }


    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean result = true;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
        return result;
    }

    ;


    /**
     * Execution entry point.
     */
    public static void main(String[] args) {

        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21,24, 25};
        System.out.println(findMedianSortedArrays(x,y));

       /* if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }*/
    }
}