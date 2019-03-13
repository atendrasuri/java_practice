package com.suri.datastructure.mathematical;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/03/19
 * @Description: (Overwrite)
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * @History:
 */
public class RectangleOverlapping {

    public static void main(String[] args) {
        int rec1[] ={0,0,2,2};
        int rec2[] ={1,1,3,3};



        System.out.println("  "+isRectangleOverlap(rec1,rec2));


        int rec11[] = {0,0,1,1};
        int rec22[] = {1,0,2,1};

        System.out.println(" "+isRectangleOverlap(rec11,rec22));

    }

        public static boolean  isRectangleOverlap(int[] rec1, int[] rec2) {
            int x1= rec1[0];
            int y1= rec1[1];
            int x2= rec1[2];
            int y2= rec1[3];



            int X1= rec2[0];
            int Y1= rec2[1];
            int X2= rec2[2];
            int Y2= rec2[3];

            if(Math.min(X2,x2)-Math.max(X1,x1)<=0){
                return false;
            }

            if(Math.min(Y2,y2)-Math.max(Y1,y1)<=0){
                return false;
            }
            return true;
        }

}