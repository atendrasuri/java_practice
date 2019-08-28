package com.suri.java.concurrency;



/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 26/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ThreadLocalExample {
  public static void main(String[] args) {

    CustomerThread customerThread1 = new CustomerThread("thread1");
    CustomerThread customerThread2 = new CustomerThread("thread2");
    CustomerThread customerThread3 = new CustomerThread("thread3");
    CustomerThread customerThread4 = new CustomerThread("thread4");
    CustomerThread customerThread5 = new CustomerThread("thread5");

    customerThread1.start();
    customerThread2.start();
    customerThread3.start();
    customerThread4.start();
    customerThread5.start();

  }
}

class CustomerThread extends Thread{

  static Integer custId =0;
  private static ThreadLocal threadLocal = new ThreadLocal(){
    @Override
    protected Object initialValue() {
      return ++custId;
    }
  };
  CustomerThread(String name){
    super(name);
  }

  public void run(){
    System.out.println(Thread.currentThread().getName()+"executing with customerId"+ threadLocal.get());
  }

}