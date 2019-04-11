package com.suri.java.threading;

import java.util.LinkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerWaitNotify {

    public static void main(String[] args) {

        LinkedList<Integer> queue= new LinkedList<>();

        Thread prod = new Thread(new ProducerWaitNotify(queue));

        Thread cons= new Thread(new ConsumerWaitNotify(queue));


        prod.setName("Producer");
        cons.setName("Consumer");

       prod.start();
       cons.start();

    }
}

class ProducerWaitNotify implements Runnable{

    LinkedList<Integer> queue;

    int capacity=5;
    int val=0;

    public ProducerWaitNotify(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true){
            synchronized (queue){

                while(queue.size()==capacity){
                    try {
                       queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(val++);
                System.out.print(Thread.currentThread().getName()+"producing "+val);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }

    }
}

class ConsumerWaitNotify implements Runnable{

    LinkedList<Integer> queue;

    public ConsumerWaitNotify(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true){
            synchronized (queue){
                while(queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("consuming = "+queue.removeFirst());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }

    }
}