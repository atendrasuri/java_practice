/* Problem Name is &&& SubArray Exceeding Sum &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
 Instructions to candidate.
  1) Your task is ultimately to implement a function that takes in an array of non-negative numbers and an integer.
   You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
   and -1 if no such sum exists.
  2) Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
  3) Consider adding some additional tests in doTestsPass().
  4) Implement subArrayExceedsSum() correctly.
  5) If time permits, some possible follow-ups.
*/

public class Solution
{
  public static int subArrayExceedsSum(int arr[], int target )
  {
  return 0;
  }

  /**
  * int doTestsPass()
  * Returns 1 if all tests pass. Otherwise returns 0.
  */
  public static void doTestsPass()
  {
  boolean result = true; 
  int[] arr = { 1, 2, 3, 4 };
  result = result && subArrayExceedsSum( arr, 6 ) == 2;
  result = result && subArrayExceedsSum( arr, 12 ) == -1;

  if( result )
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  };

  /**
   * Execution entry point.
  */
  public static void main(String[] args)
  {
  doTestsPass();
  }
};