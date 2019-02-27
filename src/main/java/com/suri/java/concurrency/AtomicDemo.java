package com.suri.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 26/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class AtomicDemo {

    public static void main(String[] args) {

        AtomicCounter obj= new AtomicCounter();

        obj.increment();

        System.out.println(obj.value());

    }

}

class AtomicCounter{

    private AtomicInteger c = new AtomicInteger(1);

    public void increment(){
        c.incrementAndGet();
    }

    public void decrement(){
        c.decrementAndGet();
    }

    public int value(){
       return c.get();
    }





}