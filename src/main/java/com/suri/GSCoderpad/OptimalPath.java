package com.suri.GSCoderpad;/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */

import java.io.*;
import java.util.*;

class OptimalPath {
    /*
     **  Find the optimal path.
     */
    public static Integer optimalPath(Integer[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        int path[][] = new int[M][N];

        path[M - 1][0] = grid[M - 1][0];


        for (int i = 1; i < N; i++) {
            path[M - 1][i] = path[M - 1][i - 1] + grid[M - 1][i];
        }

        for (int i = M- 2; i >= 0; i--) {
            path[i][0] = path[i + 1][0] + grid[i][0];
        }

        for (int i = M - 2; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                path[i][j] = Math.max(path[i][j - 1], path[i + 1][j]) + grid[i][j];
            }
        }


        return path[0][N - 1];
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;
        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}