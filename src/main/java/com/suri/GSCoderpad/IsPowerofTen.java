package com.suri.GSCoderpad;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement isPowerOf10() correctly.
 *  4) If time permits, some possible follow-ups.
 */


public class IsPowerofTen
{
  /**
   * bool isPowerOf10(int x)
   * Returns true if x is a power-of-10. Otherwise returns false.
   */
  public static boolean isPowerOf10(int x)
  {

    int y = 10;
    double n = y;

    if (x == 1) {
      return true;
    }

    if (x < 1) {
      while (n > x) {
        n = n / y;
      }
    } else {
      while (n < x) {
        n = n * y;
      }
    }
    return n == x;


  }


  /**
   * bool doTestsPass()
   * Runs various tests. Returns true if tests pass. Otherwise,
   * returns false.
   */
  public static boolean doTestsPass()
  {
  // todo: implement more tests, please
  // feel free to make testing more elegant
  int[] isPowerList = {10};
  int[] isNotPowerList = {3};

  for(int i : isPowerList)
  {
    if(!isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  for(int i : isNotPowerList)
  {
    if(isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  System.out.println("All tested passed");
  return true;
  };


  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
  doTestsPass();
  }
}