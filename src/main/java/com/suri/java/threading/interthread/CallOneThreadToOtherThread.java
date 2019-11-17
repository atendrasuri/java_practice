package com.suri.java.threading.interthread;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CallOneThreadToOtherThread {

  public static void main(String[] args) {
    MyLock myLock = new MyLock();
    myLock.sharedResource=1;

    MyThread myThread = new MyThread(myLock);

    MyThread2 myThread2 = new MyThread2(myLock);

    MyThread3 myThread3 = new MyThread3(myLock);

    myThread.start();
    myThread2.start();
    myThread3.start();

  }
}

class MyLock{

  public volatile int sharedResource;
}

class MyThread extends Thread{

private MyLock myLock;
  MyThread(MyLock sharedResource){
    this.myLock = sharedResource;
  }

  public void run(){

    while(myLock.sharedResource==1){
      System.out.println("Hi");
      myLock.sharedResource =2;
    }
  }
}

class MyThread2 extends Thread{

  private MyLock myLock;
  MyThread2(MyLock sharedResource){
    this.myLock = sharedResource;
  }

  public void run(){

    while(myLock.sharedResource==2){
      System.out.println("Hello");
      myLock.sharedResource =3;
    }
  }
}

class MyThread3 extends Thread{

  private MyLock myLock;
  MyThread3(MyLock sharedResource){
    this.myLock = sharedResource;
  }

  public void run(){

    while(myLock.sharedResource==3){
      System.out.println("Welcome");
      myLock.sharedResource =1;
    }
  }
}