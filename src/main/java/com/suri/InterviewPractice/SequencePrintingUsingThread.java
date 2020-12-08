package com.suri.InterviewPractice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SequencePrintingUsingThread {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(1);

        Print t1= new Print(ai,1,"A");
        Print t2= new Print(ai,2,"B");
        Print t3= new Print(ai,0,"C");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Print extends Thread {

    AtomicInteger ai;
    int b;
    String c;

    Print(AtomicInteger ai, int b, String c){
        this.ai=ai;
        this.b=b;
        this.c=c;
    }


    public void run(){


        while(true){

            synchronized (ai){

                int val= ai.intValue();
             if(val>=50){
                 ai.notifyAll();
                 break;

             }else {
                 if (val % 3 == b) {
                     System.out.println(" " + c + " -->" + val);
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