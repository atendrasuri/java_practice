package com.suri.InterviewPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintNumberusingThread {

    public static void main(String[] args) {
        PrintNumber obj = new PrintNumber();
        PrintNumberThread t1 = new PrintNumberThread(1,obj);
        PrintNumberThread t2 = new PrintNumberThread(2,obj);

        t1.setName("odd");
        t2.setName("even");
        t1.start();
        t2.start();


    }
}


class PrintNumberThread extends Thread {
    int num_flag;
    PrintNumber obj;

    public PrintNumberThread(int num_flag, PrintNumber obj) {
        this.num_flag=num_flag;
        this.obj=obj;
    }


    public void run(){


            if(num_flag==1){
                obj.printOdd();
            }
             if(num_flag==2){
                obj.printEven();
            }

    }
}
class PrintNumber{

    int num_flag =1;


    public void printOdd(){


        for(int i=1;i<=30;i=i+2){

            synchronized (this){
                while(num_flag!=1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(""+Thread.currentThread().getName()+"-->"+i);
                num_flag=2;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }
    }
    public void printEven(){


        for(int i=2;i<=30;i=i+2){

            synchronized (this){
                while(num_flag!=2){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(""+Thread.currentThread().getName()+"-->"+i);
                num_flag=1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }
    }
}