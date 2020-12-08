package com.suri.java.concurrency.synchronization;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/01/20
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Synch {


    public synchronized void m1() {
    }
    public synchronized void m2() {
      m1();
    }
    public static void main(String[] args) {
      Synch s = new Synch();
      s.m2();
      System.out.println("done");
    }

}