package com.suri.datastructure.mathematical;

/**
 * @Author: Atendra Kumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 26/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Given a circle of radius r in 2-D with origin or (0, 0) as center.
 * The task is to find the total lattice points on circumference.
 * Lattice Points are points with coordinates as integers in 2-D space.
 * @History:
 */
public class CircleLatticePoints {

    public static void main(String[] args) {


        int  r = 5;
        System.out.println("Total number of Lattice point :"+countLatticePoint(r));

    }

    public static int countLatticePoint(int r) {


        if (r < 0) {
            return 0;
        }

        int result = 4;

        for (int x = 1; x < r; x++) {
            int ySquare = (r * r) - (x* x);

            int y = (int) Math.sqrt(ySquare);

            if (y*y == ySquare)
                result += 4;
        }
       return result;
    }
}
