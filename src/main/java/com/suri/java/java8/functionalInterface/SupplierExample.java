package com.suri.java.java8.functionalInterface;

import java.util.function.Supplier;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * The Supplier Interface is a functional interface and part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
 * It represents a function which does not take in any argument but produces a value of type T.
 *
 * Hence this functional interface takes in only one generic namely:-
 *
 * T: denotes the type of the result
 * The lambda expression assigned to an object of Supplier type is used to define its get() which eventually produces a value. Suppliers are useful when we don’t need to supply any value and obtain a result at the same time.
 *
 * The Supplier interface consists of only one function:
 *
 * 1. get()
 * This method does not take in any argument but produces a value of type T.
 *
 * Syntax:
 *
 * T get()
 * Returns: This method returns a value of type T.
 *
 * Below is the code to illustrate get() method:
 */
public class SupplierExample {
  public static void main(String[] args) {
    Supplier<Student1> supplier = ()->new Student1(100, "Hello");

    System.out.println(supplier.get());

    // This function returns a random value.
    Supplier<Double> randomValue = () -> Math.random();

    // Print the random value using get()
    System.out.println(randomValue.get());
  }

}
class Student1{

  int id;
  String name;

  Student1(int id , String name){
    this.id=id;
    this.name=name;
  }
}