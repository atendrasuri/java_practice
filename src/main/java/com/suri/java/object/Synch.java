package com.suri.java.object;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Synch {
    // Sleeps for 5 seconds
    private static void do_stuff() {
        try {
            System.out.println("A"+Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public synchronized static void m1() {
        System.out.println("hello");
        do_stuff();
    }
    public synchronized static void m2() {
        do_stuff();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                Synch s = new Synch();
                s.m1();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Synch s = new Synch();
                s.m2();
            }
        };
        t1.setName("AA");
        t1.start();
        t2.setName("BB");
        t2.start();
        System.out.println("Done");
    }
}