package com.suri.leetcode.medium;

import java.util.Scanner;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Soln {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int i = 1; i <= T; i++) {
      int L = sc.nextInt();
      int R = sc.nextInt();
      int finalResutl = 0;
      for (int j = L; j <= R; j++) {

        int num = j;
        int result = 0;
        ;
        while (num > 0 || result != 1) {
          if (num == 0) {
            num = result;
            result = 0;
          }
          int r = num % 10;
          result += r * r;
          num = num / 10;

        }
        if (result == 1) {
          finalResutl += j;
        }

      }
      System.out.println(finalResutl);
    }
  }
}