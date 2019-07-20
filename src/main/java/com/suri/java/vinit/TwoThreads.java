package com.suri.java.vinit;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TwoThreads implements Runnable{

    private   int i=0;

    @Override
    public void run() {

        while(i<500){

        }
        System.out.println("Not waiting anymore!");

    }

    class Reader implements Runnable{

        @Override
        public void run() {
            for(i=0;i<1000;i++){
                System.out.println(i);
            }
        }
    }

    void runIt()  {
        Thread walker = new Thread(this);
        Thread reader = new Thread(new Reader());
        walker.start();
        reader.start();




        try {
            walker.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TwoThreads twoThreads = new TwoThreads();
        twoThreads.runIt();
    }
}