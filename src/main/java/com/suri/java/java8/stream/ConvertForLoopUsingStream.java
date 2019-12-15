package com.suri.java.java8.stream;

import java.util.stream.IntStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/12/19
 * @Description: (Overwrite)
 * convert the following code into stream.
 *    for(int i=0;i<30;i+=3){
 *     System.out.println(i);
 *    }
 */
public class ConvertForLoopUsingStream {
  public static void main(String[] args) {

    /*for(int i=0;i<=30;i++){
     System.out.println(i);
     }*/
    IntStream.range(0,31).forEach(x->System.out.print(x+" "));

    /*for(int i=0;i<=30;i+=3){
      System.out.println(i);
     }*/
    System.out.println();
    IntStream.iterate(0,n->n+3).limit(11).forEach(x-> System.out.print(x+" "));


  }
}