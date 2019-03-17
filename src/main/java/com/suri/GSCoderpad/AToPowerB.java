package com.suri.GSCoderpad;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Implement power(base,exp) correctly. Assume exp is an integer. 
 *  3) Consider adding some additional tests in doTestsPass().
 *  4) If time permits, some possible follow-ups.
 */

public class AToPowerB {

  /* Given base and integer exponent, compute value of base raised to the power of exponent.
   * Can you implement a solution faster than O(exp)? 
   */
  public static double power(double base, int exp) {
    if (exp == 0) {
      return 1;
    }

    if (exp > 0) {
      return pow(base, exp);
    } else {
      return 1 / pow(base, Math.abs(exp));
    }

  }

    static double pow(double base, int exp){
      double p=1.0;
      for(int i=1;i<=exp;i++){
        p= p*base;
    }
    return p;
  }

  /* returns true if all tests pass, false otherwise */  
  public static boolean doTestsPass() {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    boolean testsPass = true;
    double result = power(2,-2);
    return testsPass && result==0.25;
  }

  public static void main( String[] args ) {
    if(doTestsPass()){
      System.out.println("All tests pass");
    }
    else{
      System.out.println("There are test failures");
    }
  }
}