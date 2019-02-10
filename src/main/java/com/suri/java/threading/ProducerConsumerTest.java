package com.suri.java.threading;

import java.util.LinkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {

        LinkedList sharedList = new LinkedList();

        Thread t1 = new Thread(new Producer1(sharedList));

        Thread t2 = new Thread(new Consumer1(sharedList));

        t1.start();
        t2.start();


    }
}

class Producer1 implements Runnable {
    LinkedList sharedList;
    int capacity = 2;
    int val = 0;

    Producer1(LinkedList sharedList) {
        this.sharedList = sharedList;
    }

    public void run() {

        while (true) {
            synchronized (sharedList) {

                while (sharedList.size() == capacity) {
                    try {
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("producind element " + val);
                sharedList.add(val++);
                sharedList.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }


    }

}

class Consumer1 implements Runnable {

    LinkedList sharedList;

    Consumer1(LinkedList sharedList) {
        this.sharedList = sharedList;
    }

    public void run() {

        while (true) {
            synchronized (sharedList) {

                while (sharedList.size() == 0) {
                    try {
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consumingelement " + sharedList.removeFirst());
                sharedList.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }


    }


}


