package com.suri.designpattern.singleton;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SingleTonEnum {

    public static void main(String[] args) {

        SingletonWithEnum res1 = SingletonWithEnum.INSTANCE1;
        SingletonWithEnum res2 = SingletonWithEnum.INSTANCE1;


        System.out.println(res1==res2);
        res1.fun();
    }
}


enum SingletonWithEnum{

    INSTANCE1;
    private SingletonWithEnum(){
        System.out.println(" Hello!!! I am Singleton constructor");
    }

    public void fun(){
        System.out.println("Hello");
    }



}