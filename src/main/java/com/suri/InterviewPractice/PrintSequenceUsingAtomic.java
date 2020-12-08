package com.suri.InterviewPractice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintSequenceUsingAtomic {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(1);

        Thread t1= new Thread(new PrintNumberAtomic(ai,1,"A"));
        Thread t2= new Thread(new PrintNumberAtomic(ai,2,"B"));
        Thread t3= new Thread(new PrintNumberAtomic(ai,0,"C"));

        t1.start();
        t2.start();
        t3.start();

    }
}

class PrintNumberAtomic implements Runnable{

    AtomicInteger ai;
    int r;
    String name;

    public PrintNumberAtomic(AtomicInteger ai, int r, String name) {
        this.ai = ai;
        this.r = r;
        this.name = name;
    }

    @Override
    public void run() {

        while(true){
            synchronized (ai){
                int i= ai.intValue();

                if(i>=10){
                    ai.notifyAll();
                    break;
                }else{

                    if(i%3==r){
                        System.out.println(""+name+"-->"+i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ai.getAndIncrement();
                        ai.notifyAll();
                    }
                    else{
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