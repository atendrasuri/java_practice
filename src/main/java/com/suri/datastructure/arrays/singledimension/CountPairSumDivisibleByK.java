package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CountPairSumDivisibleByK {

  public static void main(String[] args) {

    int A[] = {2, 2, 1, 7, 5, 3};

    System.out.println(countKdivPairs(A, 6, 4));
  }

  static int countKdivPairs(int A[], int n, int K) {
    // Create a frequency array to count
    // occurrences of all remainders when
    // divided by K
    int freq[] = new int[K];

    // Count occurrences of all remainders
    for (int i = 0; i < n; i++)
      ++freq[A[i] % K];

    // If both pairs are divisible by 'K'
    int sum = freq[0] * (freq[0] - 1) / 2;

    // count for all i and (k-i)
    // freq pairs
    for (int i = 1; i <= K / 2 && i != (K - i); i++) {
      sum += freq[i] * freq[K - i];
    }
    // If K is even
    if (K % 2 == 0){
      sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
    }

    return sum;
  }
}