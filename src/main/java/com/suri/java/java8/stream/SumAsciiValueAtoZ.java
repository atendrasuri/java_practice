package com.suri.java.java8.stream;

import java.util.stream.IntStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/12/19
 * @Description: (Overwrite)
 * sum all the ascii value from 'a' - 'z' using java8 stream.
 *
 * output = 2847
 */
public class SumAsciiValueAtoZ {
  public static void main(String[] args) {

    int sum1=0;
    for(int i=97;i<123;i++){
      sum1+= i;
    }
    System.out.println(sum1);

    int sum = IntStream.range('a','z'+1).sum();
    int sum2 = IntStream.iterate('a',n->n+1).limit(26).sum();
    System.out.println(sum2);
    System.out.println(sum);
  }
}