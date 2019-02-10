package com.suri.InterviewPractice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerBlockingQ {

    public static void main(String[] args) {

        BlockingQueue sharedQ = new LinkedBlockingDeque();

        Thread t1= new Thread(new Producer1(sharedQ));
        Thread t2= new Thread(new Consumer1(sharedQ));

        t1.start();
        t2.start();



    }
}


class Producer1 implements Runnable
{
    BlockingQueue sharedQ;
    int val =0;
    public Producer1(BlockingQueue sharedQ) {
        this.sharedQ=sharedQ;
    }

    @Override
    public void run() {

        while(sharedQ.size()<=10){
            System.out.println("producing "+val);
            try {
                sharedQ.put(val++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class Consumer1 implements Runnable{
    BlockingQueue sharedQ;
    public Consumer1(BlockingQueue sharedQ) {
        this.sharedQ=sharedQ;
    }

    @Override
    public void run() {

        while(sharedQ.size()>=0){
            try {
                System.out.println("consuming "+sharedQ.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}