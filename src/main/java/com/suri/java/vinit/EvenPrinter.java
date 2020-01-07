package com.suri.java.vinit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenPrinter {
  private static int limit;
  private static AtomicInteger counter;
  private static Semaphore oddSemaphore;
  private static Semaphore evenSemaphore;

  EvenPrinter(int _limit, AtomicInteger _counter, Semaphore _oddSema, Semaphore _evenSema) {
    limit = _limit;
    counter = _counter;
    oddSemaphore = _oddSema;
    evenSemaphore = _evenSema;
  }

  public void printEven() throws InterruptedException {

    while (counter.get() < limit) {
      evenSemaphore.acquire();

      if (counter.get() % 2 == 0) {
        System.out.println(Thread.currentThread().getName() + " " + counter.get());
        Thread.sleep(1000);
        counter.incrementAndGet();

      }
      oddSemaphore.release();
    }

  }
}
