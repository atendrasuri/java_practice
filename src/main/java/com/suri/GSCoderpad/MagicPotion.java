package com.suri.GSCoderpad;/*
Instructions to candidate.
  1) Run this code in the REPL to observe its behaviour. The
   execution entry point is main.
  2) Consider adding some additional tests in doTestsPass().
  3) Implement minimalSteps() correctly.
  4) If time permits, some possible follow-ups.

Question: 
Hermione is preparing a cheat-sheet for her final exam in Potions class. 
To create a potion, one must combine ingredients in a specific order, any of which may be repeated. 

As an example, consider the following potion which uses 4 distinct ingredients 
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Hermione realizes she can save tremendous space on her cheat-sheet by introducing a 
special instruction, '*', which means "repeat from the beginning". 

Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,E

Your job is to write a function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode the potion on Hermione's Cheat Sheet.
*/

public class MagicPotion
{
  private int minimalSteps( String ingredients )
  {
  return 0;
  }

  /**
   * Returns true if the tests pass. Otherwise, false.
   */
  private boolean doTestsPass()
  {
  return minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5;
  }

  /**
   * Execution entry point.
   */
  public static void main( String[] args )
  {
    MagicPotion solution = new MagicPotion( );
  if ( solution.doTestsPass( ) )
  {
    System.out.println( "All tests passed" );
  }
  else
  {
    System.out.println( "Tests failed" );
  }
  }
}