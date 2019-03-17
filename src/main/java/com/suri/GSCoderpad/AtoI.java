package com.suri.GSCoderpad;/* Problem Name is &&& atoi &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) There are bugs in the implementation of atoi(). Consider
 *     adding some relevant tests.
 *  3) Correct the implementation of atoi(). Feel free to use
 *     print-style debugging in the absence of a true debugger.
 *  4) If time permits, consider adding robustness to atoi().
 *     For example, what type of input checking would be useful?
 */


public class AtoI
{
  /**
   * Takes a string str and returns the int value represented by
   * the string. For example, atoi("42") returns 42.
   */
  public static int atoi(String str)
  {
  int result = 0;
  int strLength = str.length();

  for(int i = 0; i < strLength; i++)
  {
    result = 10*result + str.charAt(i)-'0';
  }

  return result;
  };


  /**
   * boolean doTestsPass()
   * Returns true if all tests pass. Otherwise returns false.
   */
  public static boolean doTestsPass()
  {
  // todo: implement more tests, please
  // feel free to make testing more elegant
  boolean result = true;
  result = result &&( atoi("424")==424);
  //result = result && (1 != 2);

  return result;
  };


  /**
   * Execution entry point.
   */
  public static void main(String[] args)
  {
  if(doTestsPass())
  {
    System.out.println("All tests pass");
  }
  else
  {
    System.out.println("There are test failures");
  }
  }
}