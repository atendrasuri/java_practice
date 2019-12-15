package com.suri.java.java8.stream;

import java.util.stream.IntStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Program to sum all the numbers divisible by 3 and 5 for a given number
 * Given the integer N, the task is to sum all the numbers less than N, which are divisible by 3 and 5.
 *
 * Examples :
 *
 * Input : 50
 * Output : 0 15 30 45
 *
 * Input : 100
 * Output : 0 15 30 45 60 75 90
 */
public class SumNumbers {
  public static void main(String[] args) {

    System.out.println(findSum(100));
   // System.out.println(count(100));

  }

  public static int findSum(int nVal){


    int sum= IntStream.range(1,nVal).filter(x->x%3==0|| x%5==0).sum();
    IntStream.iterate(0,n->n+3).limit(10).forEach(x-> System.out.println(x));
    //IntStream.range(1,31).forEach(x-> System.out.println(x+=3));
    //return sum;
    return 0;
  }
  public static Long count(int nVal){

    Long count= IntStream.range(1,nVal).filter(x->x%3==0|| x%5==0).count();
    return count;
  }
}