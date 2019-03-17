/* Problem Name is &&& Unique Tuples &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement uniqueTuples() correctly.
 * 4) If time permits, try to improve your implementation.
 */

import java.util.HashSet;

public class Solution {

  /**
   *  HashSet<String> uniqueTuples( String input, int len )
   *
   * Given a string and size of the tuples, extracts all unique tuples(substrings) of the given size.
   *
   */

  public static HashSet<String> uniqueTuples( String input, int len ) {
    // TODO: Implement solution
    HashSet<String> result = new HashSet<String>();
    result.add( "aa" );
    result.add( "ab" );
    return result;
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