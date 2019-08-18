package com.suri.java.java8;

import java.util.function.Function;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * The Function Interface is a functional interface and part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
 * It represents a function which takes in one argument and produces a result.
 *
 * Hence this functional interface which takes in 2 generics namely:-
 *
 * T: denotes the type of the input argument
 * R: denotes the return type of the function
 * The lambda expression assigned to an object of Function type is used to define its apply() which eventually applies the given function on the argument.
 *
 * Methods in Function Interface
 * The Function interface consists of the following 4 methods:
 *
 * 1. apply()
 * This method applies the given function on its only argument.
 *
 * Syntax:
 *
 * R apply(T t)
 * Parameters: This method takes in only one parameter t which is the function argument
 *
 * Returns: This method returns the function result which is of type R.
 *
 * Below is the code to illustrate apply() method:
 *
 * https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
 */
public class FunctionExample {
  public static void main(String[] args) {

    Function<Integer,Integer>f = a->2*a;

    System.out.println(f.apply(10));
  }
}



