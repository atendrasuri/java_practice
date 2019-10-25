package com.suri.java.concurrency.executorservice;

import java.util.concurrent.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * https://stackoverflow.com/questions/17659510/core-pool-size-vs-maximum-pool-size-in-threadpoolexecutor
 */
public class ThreadPoolDemo {

  public static void main(String[] args) {

    ExecutorService ex = new ThreadPoolExecutor(1,4,100l, TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

    for(int i=0;i<14;i++){
      ex.submit(new MyTask());
    }
  }
}

class MyTask implements Runnable{

  @Override
  public void run() {

    while(true){
      System.out.println("Running "+Thread.currentThread().getName());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}