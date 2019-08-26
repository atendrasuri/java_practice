package com.suri.java.concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * public class CompletableFuture<T>
 * extends Object
 * implements Future<T>, CompletionStage<T>
 * A Future that may be explicitly completed (setting its value and status), and may be used as a CompletionStage, supporting dependent functions and actions that trigger upon its completion.
 * When two or more threads attempt to complete, completeExceptionally, or cancel a CompletableFuture, only one of them succeeds.
 *
 * In addition to these and related methods for directly manipulating status and results, CompletableFuture implements interface CompletionStage with the following policies:
 *
 * Actions supplied for dependent completions of non-async methods may be performed by the thread that completes the current CompletableFuture, or by any other caller of a completion method.
 * All async methods without an explicit Executor argument are performed using the ForkJoinPool.commonPool() (unless it does not support a parallelism level of at least two, in which case, a new Thread is created to run each task). To simplify monitoring, debugging, and tracking, all generated asynchronous tasks are instances of the marker interface CompletableFuture.AsynchronousCompletionTask.
 * All CompletionStage methods are implemented independently of other public methods, so the behavior of one method is not impacted by overrides of others in subclasses.
 * CompletableFuture also implements Future with the following policies:
 *
 * Since (unlike FutureTask) this class has no direct control over the computation that causes it to be completed, cancellation is treated as just another form of exceptional completion. Method cancel has the same effect as completeExceptionally(new CancellationException()). Method isCompletedExceptionally() can be used to determine if a CompletableFuture completed in any exceptional fashion.
 * In case of exceptional completion with a CompletionException, methods get() and get(long, TimeUnit) throw an ExecutionException with the same cause as held in the corresponding CompletionException. To simplify usage in most contexts, this class also defines methods join() and getNow(T) that instead throw the CompletionException directly in these cases.
 */
public class CompletableFutureExample {
  public static void main(String[] args) {
    for(int i=0;i<1000;i++) {
      CompletableFuture.supplyAsync(() -> getNumber())
              .thenApply(x -> getMultiPly(x))
              .thenAccept(x -> System.out.println(x)).toString();
    }
    System.out.println("Main Thread");

  }

  public static Integer getNumber(){
    return 5;
  }

  public static Integer getMultiPly(Integer x){
    return x*5;
  }
}
