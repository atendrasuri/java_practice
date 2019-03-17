/* Problem Name is &&& Reverse String &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour.  *     The execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement reverseStr( String str ) correctly.
 *  4) If time permits, some possible follow-ups.
 */

public class Solution{
  /**
   * public static String reverseStr( String str )
   * Takes String str and returns a new String
   * such that the characters are in reversed order.
   * Example: reverseStr(str) where str is "abcd" returns "dcba".
   */
  public static String reverseStr( String str ){
    // todo: implement
    return "Hello World";
  };

  /**
   * public static boolean doTestsPass()
   * Returns true if all tests pass. Otherwise returns false
   */
  public static boolean doTestsPass(){
    // todo: implement more tests, please
    // feel free to make testing more elegant
    String testString;
    String solution;
    boolean result = true;

    result = result && reverseStr("abcd").equals("dcba");

    return result;
  };


  /**
   * Execution entry point.
   */
  public static void main(String[] args){
  if(doTestsPass()){
    System.out.println("All tests pass");
  }
  else{
    System.out.println("There are test failures");
  }

   }
}