package com.suri.datastructure.arrays.singledimension.runningStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindMedianRunningStream {

    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {


        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }


    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());

        }
    }

    public static double getmedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size()==smallerHeap.size()){
           return (double)(biggerHeap.peek()+smallerHeap.peek())/2;
        }else{
            return biggerHeap.peek();
        }
    }

    public static double[] getmedians(int[] arr){
       // PriorityQueue<Integer> lowers = new PriorityQueue<>((Integer a, Integer b)-> -1*(a-b));

        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1*a.compareTo(b);
            }
        });

        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double medians[] = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getmedian(lowers, highers);

        }

        return medians;
    }

    public static void main(String[] args) {


        int arr[] = {12,4,5,3,8,7};

        double medians[] = getmedians(arr);

        for(double d: medians){
            System.out.println(d+" ");
        }

    }


}