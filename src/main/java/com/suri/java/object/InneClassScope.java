package com.suri.java.object;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */

interface CustomInterface {
  int getData();
}

public class InneClassScope {

  private int data = 15;

  public static void main(String[] args) {

    //new Thread(()-> System.out.println("Hello")).start();

    CustomInterface customInterface = new CustomInterface() {
      private int data = 5;

      @Override
      public int getData() {
        return data;
      }

      public int getDetails() {
        return data;
      }
    };
    InneClassScope inneClassScope = new InneClassScope();

    System.out.println(customInterface.getData() + /*customInterface.getDetails()*/+inneClassScope.data);

  }
}