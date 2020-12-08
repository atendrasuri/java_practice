package com.suri.companyWise.topCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class KSmallestPair {
  public static void main(String[] args) {

    Solution sol = new Solution();

    int nums1[] = {1,1,2};
    int nums2[] = {1,2,3};
    int k = 2;

    System.out.println(sol.kSmallestPairs(nums1,nums2,k));

  }

}

class Solution {


  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums1.length == 0 || nums2.length == 0 || k == 0) {

      return result;
    }

    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();


    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {

        Pair pair = new Pair(nums1[i], nums2[j]);
        if ( priorityQueue.size() < k) {
          priorityQueue.add(pair);
        } else if (priorityQueue.size() >k ) {
          Pair temp = priorityQueue.peek();
          if (temp.compareTo(pair) >= 0) {
            priorityQueue.poll();
            priorityQueue.add(pair);
          }
        }
      }
    }

    while (!priorityQueue.isEmpty()) {
      result.add(priorityQueue.poll().toList());
    }
    return result;

  }

  class Pair implements Comparable<Pair> {
    Integer a, b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public String toString() {
      return a + "  , " + b;
    }

    List<Integer> toList() {
      List<Integer> list = new ArrayList<>();
      list.add(a);
      list.add(b);
      return list;
    }



    @Override
    public int compareTo(Pair o) {
      return (o.a + o.b) - (this.a + this.b);
      //return new Integer(o.a + o.b).compareTo(new Integer(this.a + this.b));
    }
  }
}