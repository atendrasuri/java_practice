package com.suri.GSCoderpad;/* Problem Name is &&& Reverse String Bug &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The execution entry point is main().
 * 2) Debug and fix reverseStr().
 * 3) Consider adding some additional tests in doTestsPass().
 * 4) If time permits, try to improve your implementation.
 */

public class ReverseStringBug{
  /**
   * public static String reverseStr( String str )
   * Takes String str and returns a new String
   * such that the characters are in reversed order.
   * Example: reverseStr(str) where str is "abcd" returns "dcba".
   */
  public static String reverseStr( String str ){

  if( str.length() == 1 )
   return str;

  int strLength = str.length();
  StringBuilder sb = new StringBuilder( strLength );

  for( int i = strLength; --i >= 0;)
  {
    sb.append(str.charAt(i));

  }

  return sb.toString();
  }

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