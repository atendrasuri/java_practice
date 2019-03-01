package com.suri.java.designpattern.singleton;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SingletonDemo {
    public static void main(String[] args)throws CloneNotSupportedException {
        Singleton obj1  = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        //Object obj3 = obj1.clone();

        System.out.println(""+obj1 +"---->"+obj2);
    }
}


class Singleton{


    private static Singleton singletonIntance;



    private Singleton(){

    }

    public static Singleton  getInstance(){

        if(singletonIntance==null)
        {
            synchronized (Singleton.class){
                if(singletonIntance==null){
                    singletonIntance = new  Singleton();
                }
            }
        }

        return singletonIntance;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}