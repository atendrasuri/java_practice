package com.suri.java.object;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 31/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MemberVariableTest {

  public static void main(String[] args) {

    Parent p = new Child();

    System.out.println( p.i);
    p.m1();

    System.out.println(new Child().i);

  }
}

class Parent{

  public int i=10;

  public void m1(){
    System.out.println(" I am in parent");
  }
}

class Child extends Parent{
  public int i=20;

  public void m1(){
    System.out.println("I am in child");
  }
}