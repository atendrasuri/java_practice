/* Problem Name is &&& Second Smallest &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement secondSmallest() correctly.
 *  4) If time permits, some possible follow-ups.
 */

public class Solution
{
  /**
   * int secondSmallest(int[] x)
   * Returns second smallest element in array x. If x has fewer than 2 elements returns 0.
   */
  public static int secondSmallest(int[] x)
  {
  // todo: Implement SecondSmallest
  return( 0 );
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
  int[] a = {0};
  int[] b = {0,1};

  boolean result = true;
  result &= secondSmallest( a ) == 0;
  result &= secondSmallest( b ) == 1;

  if(result)
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  return result;
  }

  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
  doTestsPass();
  }
}