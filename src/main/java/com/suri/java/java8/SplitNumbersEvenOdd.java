package com.suri.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SplitNumbersEvenOdd {
  public static void main(String[] args) {

    List<Integer> inputList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    Map<Boolean, Integer> result = inputList.stream().collect(
            Collectors.partitioningBy(x -> x%2 == 0, Collectors.summingInt(Integer::intValue)));
    System.out.println(result);
  }
}