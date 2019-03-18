package com.suri.GSCoderpad;/* Problem Name is &&& Unique Tuples &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement uniqueTuples() correctly.
 * 4) If time permits, try to improve your implementation.
 */

import java.util.HashSet;

public class UniqueTuples {

  /**
   *  HashSet<String> uniqueTuples( String input, int len )
   *
   * Given a string and size of the tuples, extracts all unique tuples(substrings) of the given size.
   *
   */

  public static HashSet<String> uniqueTuples( String input, int len ) {
    HashSet<String> resultSet = new HashSet<String>();
    int inputLength = 0;

    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    } else {
      inputLength = input.length();
    }

    if (inputLength == 0) {
      throw new IllegalArgumentException("Input string cannot be of zero length.");
    }

    if (len <= 0) {
      throw new IllegalArgumentException("Length of tuples has to be greater than zero.");
    }

    if (len > inputLength) {
      throw new IllegalArgumentException(
              "Length of the tuple cannot be more than the length of the input string.");
    }

    for (int i = 0; i < (inputLength - len + 1); i++) {
      resultSet.add(input.substring(i, (i + len)));
    }

    return resultSet;
  }

  /**
   * boolean doTestsPass()
   * Returns true if the tests pass. Otherwise returns false.
   */
  public static boolean doTestsPass() {
    // TODO: implement some tests, please
    // we've included a trivial boilerplate

    String input = "aab";
    HashSet<String> result = uniqueTuples( input, 2 );
    if( result.contains( "aa" ) && result.contains( "ab" ) ) {
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