package com.suri.java.java8;

import java.util.function.BiFunction;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * The BiFunction Interface a functional interface and a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
 * It represents a function which takes in two arguments and produces a result.
 *
 * Hence this functional interface which takes in 3 parameters namely:-
 *
 * T: denotes the type of the first argument to the function
 * U: denotes the type of the second argument to the function
 * R: denotes the return type of the function
 * The lambda expression assigned to an object of BiFunction type is used to define its apply() which eventually applies the given function on the arguments. The main advantage of using a BiFunction is that it allows us to use 2 input arguments while in function we can only have 1 input argument.
 *
 * Functions in BiFunction Interface
 * The BiFunction interface consists of the following two functions:
 *
 * 1. apply()
 * This method applies the given function to the arguments.
 *
 * Syntax:
 *
 * R apply(T t, U u)
 * Parameters: This method takes two parameters:
 *
 * t– the first function argument
 * u– the second function argument
 * Returns: This method returns the function result which is of type R.
 *
 * Below is the code to illustrate apply() method:
 */
public class BiFunctionExample {
  public static void main(String[] args) {

    // BiFunction to add 2 numbers
    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

    // Implement add using apply()
    System.out.println("Sum = " + add.apply(2, 3));

    // BiFunction to multiply 2 numbers
    BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

    // Implement add using apply()
    System.out.println("Product = " + multiply.apply(2, 3));

  }
}