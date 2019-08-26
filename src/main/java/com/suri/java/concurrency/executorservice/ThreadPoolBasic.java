package com.suri.java.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ThreadPoolBasic {

  public static void main(String[] args) {


   int coreCount=  Runtime.getRuntime().availableProcessors();
    System.out.println(coreCount);
    ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

   for(int i=0;i<10;i++){
     executorService.execute(new CpuIntensivetask());
   }

  }
}

class CpuIntensivetask implements Runnable{

  @Override
  public void run() {

    System.out.println("Executing CPU Intensive Task");
  }
}