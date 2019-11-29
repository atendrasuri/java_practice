package com.suri.bstPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
class GFG {

  // Function to generate and
  // print the required string
  static void generateString(int A, int B, int C) {
    String rt = "";
    while ((0 < A || 0 < B || 0 < C)) {


      // More 'b', append "bba"
      if (A < B ) {
        if (0 < B--) {
          rt += ('b');
        }
        if (0 < B--) {
          rt += ('b');
        }
        if (0 < A--) {
          rt += ('a');
        }

      }
      // #more c append cca


      // More 'a', append "aab"
      else if (B < A ) {
        if (0 < A--) {
          rt += ('a');
        }
        if (0 < A--) {
          rt += ('a');
        }
        if (0 < B--) {
          rt += ('b');
        }

      } else if (B < C ) {
        if (0 < C--) {
          rt += ('c');
        }
        if (0 < C--) {
          rt += ('c');
        }
        if (0 < B--) {
          rt += ('b');
        }


      }
      else if (C < B ) {
        if (0 < B--) {
          rt += ('b');
        }
        if (0 < B--) {
          rt += ('b');
        }
        if (0 < C--) {
          rt += ('c');
        }

      }

      // #more a appenc aac
      else if (C < A) {
        if (0 < A--) {
          rt += ('a');
        }
        if (0 < A--) {
          rt += ('a');
        }
        if (0 < C--) {
          rt += ('c');
        }

      }

      else if (A < C && B<C) {
        if (0 < C--) {
          rt += ('c');
        }
        if (0 < C--) {
          rt += ('c');
        }

        if (0 < A--) {
          rt += ('a');
        }
        if (0 < B--) {
          rt += ('b');
        }
      }

      if(A+B+C <=0){
        break;
      }
      // Equal number of 'a' and 'b'
      // append "ab"
      else {
        if (0 < A--) {
          rt += ('a');
        }
        if (0 < B--) {
          rt += ('b');
        }
        if (0 < C--) {
          rt += ('c');
        }
      }
    }



    System.out.println(rt);
  }

  // Driver code
  public static void main(String[] args) {
    int A = 6, B = 1,C=1;
    generateString(A, B,C);
  }
}