package com.suri.GSCoderpad;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement dotProduct() correctly.
 *  4) If time permits, try to improve your implementation.
 */

public class DotProduct {

  /**
   * long dotProduct( int[] array1, int[] array2 )
   *
   * Given two arrays of integers, returns the dot product of the arrays
   */

  public static int dotProduct( int[] array1, int[] array2 ) {
    // TODO: Implement solution
    return 8;
  }

  /**
   * boolean doTestsPass()
   * Returns true if all the tests pass. Otherwise returns false.
   */
  public static boolean doTestsPass() {
    /// TODO: implement some tests, please
    // we've included a trivial boilerplate
    int[] array1 = { 1, 2 };
    int[] array2 = { 2, 3 };
    int result = dotProduct( array1, array2 );


    if( result == 8 ) {
      System.out.println( "Test passed." );
      return true;
    } else {
      System.out.println( "Test failed." );
      return false;
    }
  }

  public static void main( String[] args ) {
    doTestsPass();
  }
}