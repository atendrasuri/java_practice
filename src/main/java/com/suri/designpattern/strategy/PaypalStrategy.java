package com.suri.designpattern.strategy;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PaypalStrategy implements PaymentStrategy {

  private String emailId;
  private String password;

  public PaypalStrategy(String email, String pwd) {
    this.emailId = email;
    this.password = pwd;
  }

  @Override
  public void pay(int amount) {
    System.out.println(amount + " paid using Paypal.");
  }

}