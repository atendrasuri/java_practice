package com.suri.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * The Consumer Interface is a functional interface and part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
 * It represents a function which takes in one argument and produces a result. However these kind of functions don’t return any value.
 *
 * Hence this functional interface which takes in one generic namely:-
 *
 * T: denotes the type of the input argument to the operation
 * The lambda expression assigned to an object of Consumer type is used to define its accept() which eventually applies the given operation on its argument. Consumers are useful when it not needed to return any value as they are expected to operate via side-effects.
 *
 * Functions in Consumer Interface
 * The Consumer interface consists of the following two functions:
 *
 * 1. accept()
 * This method accepts one value and performs the operation on the given argument
 *
 * Syntax:
 *
 * void accept(T t)
 * Parameters: This method takes in one parameter:
 *
 * t– the input argument
 * Returns: This method does not return any value.
 *
 * Below is the code to illustrate accept() method:
 */
public class ConsumersExample {
  public static void main(String[] args) {


    Consumer<Student>consumer = e->{
      System.out.println(e.id);
      System.out.println(e.name);
    };

    consumer.accept(new Student(100,"Ram"));


    // Consumer to display a number
    Consumer<Integer> display = a -> System.out.println(a);

    // Implement display using accept()
    display.accept(10);

    // Consumer to multiply 2 to every integer of a list
    Consumer<List<Integer>> modify = list ->
    {
      for (int i = 0; i < list.size(); i++)
        list.set(i, 2 * list.get(i));
    };

    // Consumer to display a list of numbers
    Consumer<List<Integer> >
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

    List<Integer> list = new ArrayList<Integer>();
    list.add(2);
    list.add(1);
    list.add(3);

    // Implement modify using accept()
    modify.accept(list);

    // Implement dispList using accept()
    dispList.accept(list);
  }
}
class Student{

  int id;
  String name;

  Student(int id , String name){
    this.id=id;
    this.name=name;
  }
}