package com.suri.companyWise.nagarro;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/12/19
 * @Description: (Overwrite)
 *Given, UDDDDUUUDD.., write an algorithm , which counts the number of floor and number of basements.
 */
public class CountNumberOfBasements {
  public static void main(String[] args) {


    String steps = "UDDDDUUUUDUU";

    System.out.println(countNumberOfBasement(steps));
  }

  public static int countNumberOfBasement(String steps) {

    if (steps == null || steps.length() == 0) {
      return 0;
    }
    int upside = 0;
    int downside = 0;
    int floor = 0;
    int basement = 0;

    for (int i = 0; i < steps.length(); i++) {

      char step = steps.charAt(i);

      if (step == 'U') {
        upside++;

        if (upside == downside) {
          basement++;
        }
      }
      if (step == 'D') {
        downside++;
        if (upside == downside) {
          floor++;
        }
      }
      if (upside == downside) {
        upside = 0;
        downside = 0;
      }
    }
    System.out.println(floor);
    return basement;
  }
}