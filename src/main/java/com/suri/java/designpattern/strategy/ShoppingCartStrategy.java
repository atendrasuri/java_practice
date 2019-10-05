package com.suri.java.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * <p>
 * <p>
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from the clients that use it.
 * Capture the abstraction in an interface, bury implementation details in derived classes.
 */
public class ShoppingCartStrategy {
  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();

    Item item1 = new Item("1234", 10);
    Item item2 = new Item("5678", 40);

    cart.addItem(item1);
    cart.addItem(item2);

    //pay by paypal
    cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

    //pay by credit card
    cart.pay(new CreditCardStrategy("A Kumar", "1234567890123456", "786", "12/15"));
  }
}



