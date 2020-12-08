package com.suri.java.immutable;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Mutable extends Immutable {
  private int realValue;

  public Mutable(int value) {
    super(value);

    realValue = value;
  }

  public int getValue() {
    return realValue;
  }
  public void setValue(int newValue) {
    realValue = newValue;
  }

  public static void main(String[] arg){
    Mutable obj = new Mutable(4);
    Immutable immObj = (Immutable)obj;
    System.out.println(immObj.getValue());
    obj.setValue(8);
    System.out.println(immObj.getValue());
  }

}