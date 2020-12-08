package com.suri.problemsolving.stringBased;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class IsValidPalindrome {
  public static void main(String[] args) {

    String str = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(str));

    String str2 = "race a car";
    System.out.println(isPalindrome(str2));

  }

  public static boolean isPalindrome(String str) {

    char[] arr = str.toLowerCase().toCharArray();

    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      if (!isAlphanumeric(arr[i])) {
        i++;
        continue;
      }
      if (!isAlphanumeric(arr[j])) {
        j--;
        continue;
      }
      if (arr[i++] != arr[j--]) {
        return false;
      }

    }
    return true;
  }

  public static boolean isAlphanumeric(char x) {

    if ((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9')) {
      return true;
    }
    return false;
  }
}