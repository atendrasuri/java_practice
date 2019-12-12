package com.suri.java.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class OptionalExample {
  public static void main(String[] args) {

    Optional<List<Integer>> optionalInteger = Optional.of(Arrays.asList(1,2,3,4,5,6));

    optionalInteger.ifPresent(x->x.stream().forEach(System.out::println));

    new Thread(()-> System.out.println("Hello")).start();

  }
}