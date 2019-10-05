package com.suri.java.designpattern.strategy;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Item {

  private String upcCode;
  private int price;

  public Item(String upc, int cost){
    this.upcCode=upc;
    this.price=cost;
  }

  public String getUpcCode() {
    return upcCode;
  }

  public int getPrice() {
    return price;
  }

}