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
public class TThreadPoolTest {
  public static void main(String[] args) throws Exception {
    CustomThreadPool customThreadPool = new CustomThreadPool(2);
    Runnable task = new Task();

    customThreadPool.execute(task);
    customThreadPool.execute(task);

    customThreadPool.shutdown();
  }
}