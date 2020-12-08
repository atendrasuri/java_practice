package com.suri.java.threading;

import java.util.concurrent.Semaphore;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SemaphoreProducerConsumer {
    public static void main(String[] args) {


        Semaphore producer = new Semaphore(1);
        Semaphore consumer = new Semaphore(0);

        Thread producerThread = new Thread(new SemaPhoreProducer(producer,consumer),"Producer");

        Thread consumerThread = new Thread(new SemaPhoreConsumer(consumer,producer),"Consumer");
        producerThread.start();
        consumerThread.start();
    }
}

class SemaPhoreProducer implements Runnable {

    Semaphore producer;
    Semaphore consumer;

    SemaPhoreProducer(Semaphore producer, Semaphore consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                producer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" producing " + i);

            consumer.release();
        }

    }
}

class SemaPhoreConsumer implements Runnable {

    Semaphore consumer;
    Semaphore producer;

    SemaPhoreConsumer(Semaphore consumer, Semaphore producer) {
        this.consumer = consumer;
        this.producer = producer;

    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                consumer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" consuming" + i);
            producer.release();
        }
    }
}