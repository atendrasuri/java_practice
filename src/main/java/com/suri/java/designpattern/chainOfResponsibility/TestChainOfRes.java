package com.suri.java.designpattern.chainOfResponsibility;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 30/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TestChainOfRes {
  public static void main(String[] args) {

    Chain c1 = new EvenProcessor();

    Chain c2 = new OddProcessor();

    c1.setNext(c2);

    c1.process(new Number(3));
    c1.process(new Number(5));
  }
}