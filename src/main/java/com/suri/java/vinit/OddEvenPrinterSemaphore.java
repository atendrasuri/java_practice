package com.suri.java.vinit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrinterSemaphore {
    private static int limit = 100;
    private static AtomicInteger counter = new AtomicInteger(1);
    private static Semaphore oddSemaphore = new Semaphore(1);
    private static Semaphore evenSemaphore = new Semaphore(0);

    public static void main(String[] args) {
        OddPrinter oddPrinter = new OddPrinter(limit, counter, oddSemaphore, evenSemaphore);
        EvenPrinter evenPrinter = new EvenPrinter(limit, counter, oddSemaphore, evenSemaphore);
        new Thread(() -> {
            try {
                oddPrinter.printOdd();
            } catch (InterruptedException ex) {
            }
        }, "odd-printer").start();
        new Thread(() -> {
            try {
                evenPrinter.printEven();
            } catch (InterruptedException ex) {
            }
        }, "even-printer").start();

    }
}
