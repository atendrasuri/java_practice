package com.suri.GSCoderpad;

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 *    execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement addFractions() correctly.
 * 4) If time permits, try to improve your implementation.
 */

public class AddFraction {

  /**
   * int[] addFractions ( int[] fraction1, int[] fraction2 )
   *
   * Given two fractions passed in as int arrays,
   * returns the fraction which is result of adding the two input fractions.
   * Fraction is represented as a two-element array - [ numerator, denominator ]
   * The returned fraction has to be in its simplest form.
   */
  public static int[] addFractions( int[] x, int[] y ) {

    int numerator = x[0] * y[1] + x[1] * y[0];
    int denominator = x[1] * y[1];

    int gcd = getGCD(numerator, denominator);
    numerator = numerator / gcd;
    denominator = denominator / gcd;

    int[] sum = { numerator, denominator };

    return sum;
  }

  private static int getGCD(int x, int y){
    int min = Math.min(x,y);
    int max = Math.max(x,y);
    int gcd = min;

    while(max%min !=0){
      gcd = max%min;
      max = min;
      min = gcd;
    }
    return gcd;
  }


  /**
   * boolean doTestsPass()
   * Returns true if all the tests pass. Otherwise returns false.
   */
  public static boolean doTestsPass() {
    // TODO: implement some tests, please
    // we've included a trivial boilerplate

    int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

    if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
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