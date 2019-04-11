package com.suri.java.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerUsingBlockingQ {

    public static void main(String[] args) {

        BlockingQueue <Integer> sharedQueue= new LinkedBlockingDeque<>();

        Thread prod= new Thread(new BlockingProducer(sharedQueue));

        Thread cons= new Thread(new BlockingConsumer(sharedQueue));
        prod.setName("producer");
        prod.start();

        cons.setName("consumer");
        cons.start();




    }
}

class BlockingProducer implements  Runnable{

    BlockingQueue <Integer> sharedQueue;
    public BlockingProducer( BlockingQueue <Integer> sharedQueue) {
        this.sharedQueue=sharedQueue;
    }

    @Override
    public void run() {

        while(true){
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+""+i);
                sharedQueue.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class BlockingConsumer implements  Runnable{

    BlockingQueue <Integer> sharedQueue;

    public BlockingConsumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(Thread.currentThread().getName()+" "+sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}