package com.suri.java.threading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 26/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintingABCUsingAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        new Student(ai, 1, "A").start();
        new Student(ai, 2, "B").start();
        new Student(ai, 0, "C").start();
    }

}

class Student extends Thread {
    AtomicInteger ai;
    int b;
    String c;

    Student(AtomicInteger a, int b, String c) {
        this.ai = a;
        this.b = b;
        this.c = c;
    }

    public void run() {
        while (true) {
            synchronized (ai) {
                int val = ai.intValue();
                if (val >= 10) {
                    ai.notifyAll();
                    break;
                } else {
                    if (val % 3 == b) {
                        System.out.println(" Thread " + b + " printing value " + c);
                        ai.getAndIncrement();
                        ai.notifyAll();
                    } else {
                        try {
                            ai.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}