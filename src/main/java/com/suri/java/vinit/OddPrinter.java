package com.suri.java.vinit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class OddPrinter {
  private static int limit;
  private static AtomicInteger counter;
  private static Semaphore oddSemaphore;
  private static Semaphore evenSemaphore;

  OddPrinter(int _limit, AtomicInteger _counter, Semaphore _oddSema, Semaphore _evenSema) {
    limit = _limit;
    counter = _counter;
    oddSemaphore = _oddSema;
    evenSemaphore = _evenSema;
  }

  public void printOdd() throws InterruptedException {
    while (counter.get() < limit) {
      oddSemaphore.acquire();
      if (counter.get() % 2 != 0) {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " " + counter.get());
        counter.incrementAndGet();
      }
      evenSemaphore.release();

    }

  }

}
