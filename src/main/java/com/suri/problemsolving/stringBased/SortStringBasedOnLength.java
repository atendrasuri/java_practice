package com.suri.problemsolving.stringBased;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/08/19
 * @Description: (Overwrite)
 * We are given an array of strings, we need to sort the array in increasing order of string lengths.
 * <p>
 * Examples:
 * <p>
 * Input : {"GeeksforGeeeks", "I", "from", "am"}
 * Output : I am from GeeksforGeeks
 */
public class SortStringBasedOnLength {
  public static void main(String[] args) {
    String str[] = {"You", "are", "beautiful", "looking"};

    List<String> list = Arrays.asList(str);

    //sortString(str);
    Collections.sort(list, new MyComparator());


    for (String s : list) {
      System.out.print(s + " ");
    }
  }

  public static void sortString(String[] str) {

    int length = str.length;


    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {

        if (str[i].length() > str[j].length()) {
          String temp = str[i];
          str[i] = str[j];
          str[j] = temp;
        }
      }
    }
  }


}

/**
 * using Comparator
 */

class MyComparator implements Comparator {

  @Override
  public int compare(Object o1, Object o2) {


    String s1 = (String) o1;
    String s2 = (String) o2;
    if (s1.length() < s2.length()) {
      return -1;
    } else if (s1.length() > s2.length()) {
      return 1;
    } else

      return 0;
  }
}