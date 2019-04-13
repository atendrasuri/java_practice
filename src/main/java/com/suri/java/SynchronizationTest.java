package com.suri.java;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/04/19
 * @Description: (Overwrite)
 * If multiple threads operating on the same object simultaneously then synchronization is required.
 * @History:
 */
public class SynchronizationTest {

    public static void main(String[] args) {

       Display display1= new Display();
        Display display2= new Display();

       MyThread myThread1= new MyThread(display1,"Suri");
       myThread1.start();

        MyThread myThread2= new MyThread(display2,"Sinha");
        myThread2.start();

    }
}


class MyThread extends Thread {
    Display display;
    String name;

    MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    public void run() {
        display.wish(name);
    }

}

class Display {

    public static synchronized void wish(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good morning ");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("" + name);
        }
    }


}


