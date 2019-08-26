package com.suri.java.java8;

import java.util.stream.Stream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FibonacciUsingJava8 {

  public static void main(String[] args) {


    Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]}).limit(10).map(n->n[0]).forEach(System.out::println);


  }
}