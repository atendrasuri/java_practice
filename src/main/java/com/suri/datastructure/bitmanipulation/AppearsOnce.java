package com.suri.datastructure.bitmanipulation;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/08/19
 * @Description: (Overwrite)
 * Find the element that occurs only once in a given set of integers while all the other numbers occur thrice.
 * Example -
 * Input : 3 3 3 4
 * Output: 4
 * <p>
 * Input : 5 5 4 8 4 5 8 9 4 8
 * Output: 9
 */
public class AppearsOnce {
  public static void main(String[] args) {

    int[] arr = { 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 };

    System.out.println(findRequiredNum(arr,3));

  }

  public static int findRequiredNum(int arr[], int n) {


    int countSetBit[] = new int[32];


    for (int i = 0; i < arr.length; i++) {


      for (int k = 0; k < 32; k++) {
        int kthSetBit = 1 << k;

        if ((arr[i] & kthSetBit) == kthSetBit) {
          countSetBit[k]++;
        }
      }
    }

    int occurredOnce = 0;

    for (int i = 0; i < 32; i++) {
      countSetBit[i] = countSetBit[i] % n;

      if (countSetBit[i] == 1) {
        occurredOnce = occurredOnce | (1 << i);

      }

    }
    return occurredOnce;
  }
}