package com.suri.java.concurrency.executorservice.customthreadpool;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CustomThreadPool {

  private BlockingQueueCustom<Runnable> blockingQueueCustom;

  private boolean poolShutDownInitited;

  CustomThreadPool(int nThread) {
    blockingQueueCustom = new LinkedBlockingQueueCustom<>(nThread);

    for (int i = 1; i <= nThread; i++) {

      ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(blockingQueueCustom, this);

      threadPoolsThread.setName("Thread-" + i);
      System.out.println("Thread-" + i + " created in ThreadPool.");
      threadPoolsThread.start();   //start thread
    }
  }

  public synchronized void execute(Runnable task) throws Exception {

    if (this.poolShutDownInitited) {
      throw new Exception("ThredPool shutdown initited, no further task can be added");
    }

    System.out.println(" Task has been  added");
    this.blockingQueueCustom.put(task);
  }

  public boolean isPoolShutDownInitited() {
    return poolShutDownInitited;
  }

  public synchronized void shutdown() {
    this.poolShutDownInitited = true;
    System.out.println("Threadpool SHUTDOWN initiated");
  }
}