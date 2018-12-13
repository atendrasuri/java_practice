package com.suri.java.object;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class AbstractDemo {

    public static void main(String[] args) {
        m1(null);

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        map.put(1,10);
        map.put(2,10);
        map.put(1,10);
        map.put(1,10);
        map.put(5,10);

        System.out.println(map.size());


    }

    public static void m1(String s1) {
        System.out.println("hello");
    }

    public static void m1(Object ob){
        System.out.println("welcome");
    }
}


 abstract class Abc{

    Abc(){

    }
 }