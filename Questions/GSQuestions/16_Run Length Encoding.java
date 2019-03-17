/* Problem Name is &&& Run Length Encoding &&& PLEASE DO NOT REMOVE THIS LINE. */

import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

 /**
 **  * Instructions to candidate.
 **  *  1) Run this code in the REPL to observe its behaviour.
 **  *  2) Consider adding some additional tests in doTestsPass().
 **  *  3) Implement rle() correctly.
 **  *  4) If time permits, try to improve your implementation.
 **


 * Implement a run length encoding function.
 *
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * ""      -> ""
 *
 */
public class Solution {

  public static String rle(String input) {
    // TODO: Implement solution
    return "";
  }


  @Test
  public void doTestsPass(){
    assertEquals("a3",rle("aaa"));
    assertEquals("a3b2c1",rle("aaabbc"));
  }


  public static void main(String[] args) throws InterruptedException     {
    JUnitCore.main("Solution");
  }
}