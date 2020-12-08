package com.suri.java.threading;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SequencePrintUsing3Thread {

    public static void main(String[] args) {
        Object lock = new Object();
        PrintSequence p1 = new PrintSequence(1);
        p1.lock = lock;
        PrintSequence p2 = new PrintSequence(2);
        p2.lock = lock;
        PrintSequence p3 = new PrintSequence(3);
        p3.lock = lock;
        PrintSequence p4 = new PrintSequence(0);
        p4.lock = lock;

        Thread t1 = new Thread(p1,"t1");
        Thread t2 = new Thread(p2,"t2");
        Thread t3 = new Thread(p3 ," t3");
        Thread t4 = new Thread(p4 ," t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //System.out.println();
    }
}



class PrintSequence implements Runnable {

    Object lock;
    private static volatile int number = 1;
    private int remainder;

    public PrintSequence(int remainder) {
        // TODO Auto-generated constructor stub
        this.remainder = remainder;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (number < 15) {
            synchronized (lock) {
                while (number % 4 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName()+ " "+number);
                number++;
                lock.notifyAll();

            }
        }
    }

}
