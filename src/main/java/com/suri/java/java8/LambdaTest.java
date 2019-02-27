package com.suri.java.java8;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LambdaTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(() ->
                System.out.println(" I am in Thread Hello")
        );

        t1.start();
        System.out.println(" I am in Main");



        // using Java8 find the max value from hashMap
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(5, 50);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println(
                map.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getValue());




        // using Java8 find the max element from list
        System.out.println(" Finding max from the list");
        List<Integer> list  =Arrays.asList(10,50,20,30);

        System.out.println(
                list.stream()
                .min(Comparator.naturalOrder())
        );


        // using Java8 sum all even numbers from the list

        System.out.println(list.stream()
                .filter(e->e%2==0)
                .mapToInt(e->e).sum());





    }
}