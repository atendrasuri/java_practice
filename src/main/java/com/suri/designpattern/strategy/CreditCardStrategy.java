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
public class CreditCardStrategy implements PaymentStrategy {

  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
    this.name = nm;
    this.cardNumber = ccNum;
    this.cvv = cvv;
    this.dateOfExpiry = expiryDate;
  }

  @Override
  public void pay(int amount) {
    System.out.println(amount + " paid with credit/debit card");
  }

}