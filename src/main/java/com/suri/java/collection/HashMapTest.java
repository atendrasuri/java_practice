package com.suri.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class HashMapTest {
  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();

    map.put("Hello",10);

    System.out.println(map.size());

  }
}