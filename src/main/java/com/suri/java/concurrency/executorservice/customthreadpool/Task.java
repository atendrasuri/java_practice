package com.suri.java.concurrency.executorservice.customthreadpool;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Task implements Runnable{
  @Override
  public void run() {
    try {
      Thread.sleep(2000);

      System.out.println(Thread.currentThread().getName()+"is executing task");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}