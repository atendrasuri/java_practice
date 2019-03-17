package com.suri.GSCoderpad;/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
**  Instructions:
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the editor below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/

class BestAverageGrade
{
  /*
  **  Find the best average grade.
  */
  public static Integer bestAverageGrade(String[][] scores)
  {
    Map<String, ArrayList<Integer>> map = new HashMap<>();

    ArrayList<Integer> list;
    for (String[] str : scores) {
      String name = str[0];
      int val = Integer.parseInt(str[1]);
      if (map.containsKey(name)) {
        list = map.get(name);
        list.add(val);
        map.put(name, list);
      } else {
        list = new ArrayList<>(Arrays.asList(val));
        map.put(name, list);
      }
    }

    int bestAvg = 0;
    for (String name : map.keySet()) {
      list = map.get(name);
      int sum = 0;
      for (Integer val : list) {
        sum += val;
      }
      int avg = sum / list.size();

      if (avg > bestAvg)
        bestAvg = avg;
    }
    return bestAvg;
  }

  /*
  **  Returns true if the tests pass. Otherwise, returns false;
  */
  public static boolean doTestsPass()
  {
    // TODO: implement more test cases
    String[][] tc1 = { { "Bobby", "87" },
               { "Charles", "100" },
               { "Eric", "64" },
               { "Charles", "22" } };

    return bestAverageGrade(tc1) == 87;
  }

  /*
  **  Execution entry point.
  */
  public static void main(String[] args)
  {
    // Run the tests
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }
  }
}