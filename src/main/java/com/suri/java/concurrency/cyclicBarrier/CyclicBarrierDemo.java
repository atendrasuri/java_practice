package com.suri.java.concurrency.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(1);

        Thread t1= new Thread(new Biker(barrier), "Biker Thread1");
        Thread t2= new Thread(new Biker(barrier), "Biker Thread2");
        Thread t3= new Thread(new Biker(barrier), "Biker Thread3");
        Thread t4= new Thread(new Biker(barrier), "Biker Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Biker implements Runnable {
    private CyclicBarrier checkPoint;

    Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has left the source");
            checkPoint.await();

            System.out.println(Thread.currentThread().getName() + " has left the first checkPoint /barrier");
            checkPoint.await();

            System.out.println(Thread.currentThread().getName() + " has left the second checkPoint /barrier");
            checkPoint.await();

            System.out.println(Thread.currentThread().getName() + " has left the third checkPoint /barrier");
            checkPoint.await();

            System.out.println(Thread.currentThread().getName() + " has left the fourth checkPoint /barrier");
            checkPoint.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}