package com.suri.java.java8.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * The BiConsumer Interface is functional Interface and part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
 * It represents a function which takes in two arguments and produces a result.
 * However these kind of functions don’t return any value.
 *
 * This functional interface takes in two generics, namely:-
 *
 * T: denotes the type of the first input argument to the operation
 * U: denotes the type of the second input argument to the operation
 * The lambda expression assigned to an object of BiConsumer type is used to define its accept() which eventually applies the given operation on its arguments.
 *
 * BiConsumers are useful when it is not required to return any value as they are expected to operate via side-effects.
 *
 * Functions in BiConsumer Interface
 * The BiConsumer interface consists of the following two functions:
 *
 * 1. accept()
 * This method accepts two values and performs the operation on the given arguments
 *
 * Syntax:
 *
 * void accept(T t, U u)
 * Parameters: This method takes in two parameters:
 *
 * t– the first input argument
 * u– the second input argument
 * Returns: This method does not return any value.
 *
 * Below is the code to illustrate accept() method:
 */
public class BiConsumersExample {
  public static void main(String[] args) {
    // Create the first list
    List<Integer> lista = new ArrayList<Integer>();
    lista.add(2);
    lista.add(1);
    lista.add(3);

    // Create the second list
    List<Integer> listb = new ArrayList<Integer>();
    listb.add(2);
    listb.add(1);
    listb.add(2);

    // BiConsumer to compare both lists
    BiConsumer<List<Integer>, List<Integer> >
            equals = (list1, list2) ->
    {
      if (list1.size() != list2.size()) {
        System.out.println("False");
      }
      else {
        for (int i = 0; i < list1.size(); i++) {
          if (list1.get(i) != list2.get(i)) {
            System.out.println("False");
            return;
          }
        }
        System.out.println("True");
      }
    };
    equals.accept(lista, listb);
  }
}

