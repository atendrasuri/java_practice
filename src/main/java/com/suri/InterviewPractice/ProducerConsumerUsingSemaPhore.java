package com.suri.InterviewPractice;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerUsingSemaPhore {
    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>(10);
        System.out.println(hs.add(10));
        System.out.println( hs.add(20));
        System.out.println( hs.add(30));
        System.out.println(hs.add(20));
        System.out.println(hs.add(10));

        System.out.println(hs);


        Semaphore prosema= new Semaphore(1);
        Semaphore consema= new Semaphore(0);

        LinkedList<Integer> linkedList = new LinkedList<>();

        Thread prod= new Thread(new SemaphoreProducer(prosema,consema,linkedList));

        Thread cons = new Thread(new SemaPhoreConsumer(prosema,consema,linkedList));

        prod.start();
        cons.start();

    }
}

class SemaphoreProducer implements Runnable{

    Semaphore prosema;
    Semaphore consema;
    LinkedList<Integer> linkedList;
    int val=0;

    public SemaphoreProducer(Semaphore prosema, Semaphore consema, LinkedList<Integer> linkedList) {
        this.prosema = prosema;
        this.consema = consema;
        this.linkedList = linkedList;
    }

    @Override
    public void run() {

        while(true){
            try {
                prosema.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            linkedList.add(val++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consema.release();

        }

    }
}

class SemaPhoreConsumer implements Runnable{

    Semaphore prosema;
    Semaphore consema;
    LinkedList<Integer> linkedList;

    public SemaPhoreConsumer(Semaphore prosema, Semaphore consema, LinkedList<Integer> linkedList) {
        this.prosema = prosema;
        this.consema = consema;
        this.linkedList = linkedList;
    }

    @Override
    public void run() {

        while(true){
            try {
                consema.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consuming  "+linkedList.remove());
            prosema.release();
        }

    }
}