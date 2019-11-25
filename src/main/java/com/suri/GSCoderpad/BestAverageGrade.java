package com.suri.GSCoderpad;/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

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

  public static Integer bestAverageGradeII(List<List<String>> scores) {

    if (scores == null || scores.isEmpty()) {
      return -1;
    }

    HashMap<String, List<Integer>> map = new HashMap<>();

    for (List<String> score : scores) {

      String name = score.get(0);
      Integer mark = Integer.parseInt(score.get(1));

      if (map.containsKey(name)) {
        List<Integer> marksList = map.get(name);
        marksList.add(mark);
        map.put(name, marksList);
      } else {
        List<Integer> markList = new ArrayList<>();
        markList.add(mark);
        map.put(name, markList);

      }
    }

    int maxAvg = Integer.MIN_VALUE;

    for(Map.Entry<String, List<Integer>> marksEntry:map.entrySet()){
      List<Integer> marks=marksEntry.getValue();
      int sum = marks.stream().mapToInt(x->x).sum();

      int avg = sum/marks.size();

      if(avg>maxAvg){
        maxAvg = avg;
      }
    }


    return maxAvg;
  }
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

    int bestAvg = Integer.MIN_VALUE;
    for (String name : map.keySet()) {
      list = map.get(name);
      int sum = 0;
      for (Integer val : list) {
        sum += val;
      }
      int avg = (int)Math.ceil(sum / list.size()-1);

      if (avg > bestAvg)
        bestAvg = avg;
    }
    System.out.println(""+bestAvg);
    return bestAvg;

  }

  /*
  **  Returns true if the tests pass. Otherwise, returns false;
  */
  public static boolean doTestsPass()
  {
    // TODO: implement more test cases
   /* String[][] tc1 = { { "Bobby", "87" },
               { "Charles", "100" },
               { "Eric", "64" },
               { "Charles", "22" } };

    return bestAverageGrade(tc1) == 87;*/

    String[][] tc1 = {
            { "Charles", "-66" },
            { "Eric", "-74" },
            { "Charles", "-66" } };

    List<List<String>> tc2 = new ArrayList<>();
    tc2.add(Arrays.asList(new String[]{ "Charles", "-66" }));
    tc2.add(Arrays.asList(new String[]{ "Eric", "-74" }));
    tc2.add(Arrays.asList(new String[]{ "Charles", "-66" }));

    //return bestAverageGrade(tc1) == -66;
    return bestAverageGradeII(tc2) == -66;
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