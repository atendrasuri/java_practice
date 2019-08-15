package com.suri.datastructure.arrays.singledimension.runningStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way.
 * For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 *
 * After reading 1st element of stream - 5 -> median - 5
 * After reading 2nd element of stream - 5, 15 -> median - 10
 * After reading 3rd element of stream - 5, 15, 1 -> median - 5
 * After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 */
public class FindMedianRunningStream {

;
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