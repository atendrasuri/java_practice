package com.suri.java.concurrency.executorservice.customthreadpool;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

  private List<E> queue;

  private int maxSize;

  public LinkedBlockingQueueCustom(int maxSize) {
    this.maxSize = maxSize;
    queue = new LinkedList<>();
  }


  @Override
  public synchronized void put(E item) throws InterruptedException {

    while (queue.size() == maxSize) {
      this.wait();
    }
    queue.add(item);
    this.notifyAll();


  }

  @Override
  public synchronized E take() throws InterruptedException {
    while (queue.size() == 0) {
      this.wait();
    }
    this.notifyAll();
    return queue.remove(0);

  }

  @Override
  public synchronized int size() {
    return queue.size();
  }
}