package com.suri.datastructure.arrays.singledimension.runningStream;

import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindKthLargest {

    public static void main(String[] args) {

        int arr[]  = {1,5,3,6,2,9};
        System.out.println(KthLargest(2,arr));
    }

     static PriorityQueue<Integer> q=null;
     static int k;

    public static int KthLargest(int k, int[] a) {

        q = new PriorityQueue<>(k);
        for (int n : a)
             add(n);

        return q.peek();
    }

    public static void add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }

    }
}