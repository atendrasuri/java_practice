package com.suri.java.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SortMapByValue {
  public static void main(String[] args) {

    HashMap<String,Integer>map = new HashMap<>();
    map.put("AB0",5);
    map.put("AB4",0);
    map.put("AB3",9);
    map.put("AB4",4);
    map.put("AB5",1);

    map.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue())
            .limit(10)
            .forEach(System.out::println);

  }
}