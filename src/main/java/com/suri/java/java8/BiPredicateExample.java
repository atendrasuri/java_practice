package com.suri.java.java8;

import java.util.function.BiPredicate;
import java.util.stream.IntStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * @FunctionalInterface
 * public interface BiPredicate<T,U>
 * Represents a predicate (boolean-valued function) of two arguments. This is the two-arity specialization of Predicate.
 * This is a functional interface whose functional method is test(Object, Object).
 */
public class BiPredicateExample {

  public static void main(String[] args) {

    BiPredicate<Integer,Integer>biPredicate = (a,b)->(a+b)%2==0;

    System.out.println(biPredicate.test(3,5));
    System.out.println(biPredicate.test(3,2));

    IntStream.range(1,100).filter(x->x%2==0).forEach(x-> System.out.println(x));
  }
}