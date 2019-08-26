package com.suri.java.concurrency.executorservice;

import java.util.concurrent.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CustomThreadPool {
  public static void main(String[] args) {

    ExecutorService executorService;
    executorService = new ThreadPoolExecutor(10,100,120, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));

    for(int i=0;i<200;i++) {
      try {
        executorService.submit(new Task());
      }catch(RejectedExecutionException re){
        System.out.println(re.getMessage());
      }
    }
  }
}

class Task implements Callable{

  @Override
  public Integer call() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Get Executed");

    return 4;
  }
}