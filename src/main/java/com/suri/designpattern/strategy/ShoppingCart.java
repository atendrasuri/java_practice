package com.suri.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
class ShoppingCart {
  //List of items
  List<Item> items;

  public ShoppingCart() {
    this.items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public int calculateTotal() {
    int sum = 0;
    for (Item item : items) {
      sum += item.getPrice();
    }
    return sum;
  }

  public void pay(PaymentStrategy paymentMethod) {
    int amount = calculateTotal();
    paymentMethod.pay(amount);
  }
}