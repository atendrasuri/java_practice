package com.suri.java.concurrency;

import java.io.Serializable;
import java.util.concurrent.*;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ExecutorFramework {
    Serializable s;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            Runnable worker = new WorkerThread(""+i);
            Future<?> res = executor.submit(worker);
            System.out.println("---->"+res.get());


        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}


class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        command = s;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
