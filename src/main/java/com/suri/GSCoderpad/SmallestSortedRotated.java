package com.suri.GSCoderpad;/* Problem Name is &&& Smallest Number &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 * Instructions to candidate.
 * 1) The execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement FindMin(int a[]) correctly.
 * 4) If time permits, discuss the solution in case there are duplicates in array.
 */

import java.util.*;

public class SmallestSortedRotated
{

  /*
   * public static int FindMin(int a[])
   * Returns the smallest number in array that has been rotated
   * For example - Array {3,4,5,6,1,2} returns 1
   * Input array was originally sorted in increasing orders
   * FindMin must have O(log n) runtime
   * Assume array does not have any duplicates.
  */

  public static int FindMin(int a[])
  {
    if(a.length==1){
      return a[0];
    }


    int index=Integer.MAX_VALUE;

    for(int i=0;i<a.length;i++){
      if(a[i]>a[i+1]){
        index=i+1;
        break;
      }
    }
    return a[index];
  }

  public static boolean doTestsPass()
  {
    /*
     * int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */

    boolean result = true;
    result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
    result = result && FindMin(new int[]{2,1}) == 1;
    result = result && FindMin(new int[]{1}) == 1;

    try {
      FindMin(null);
      result = false;
    }
    catch(Exception e)
    {
      result = result && true;
    }

    if(result)
    {
      System.out.println("All tests pass\n");
    }
    else
    {
      System.out.println("There are test failures\n");
    }
    return result;
  }

  //Execution entry point.
  public static void main(String args[])
  {
    doTestsPass();
  }
}