import java.io.*;
import java.util.*;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement primeFactorization() correctly.
 *  4) If time permits, some possible follow-ups.
 */


public class Solution
{
  /**
   * Return an array containing prime numbers whose product is x
   * Examples:
   * primeFactorization( 6 ) == [2,3]
   * primeFactorization( 5 ) == [5]
   * primeFactorization( 12 ) == [2,2,3]
   */
  public static ArrayList<Integer> primeFactorization(int x)
  {
  //To Do: implement code here
  ArrayList<Integer> factors = new ArrayList<Integer>();
  return factors;
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
  ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
  expected.add(new ArrayList<Integer>(Arrays.asList(2,3)));
  ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
  results.add(primeFactorization(6));
  
  for( int i = 0; i<expected.size(); i++ )
  {
    if( !expected.get(i).equals(results.get(i)))
    {
        System.out.println("Test failed for index: " + i);
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
