package com.suri.java.collection;

import java.util.*;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class HashSetTest {

    public static void main(String[] args) {
        Integer r1=0;

        Map<Integer,Integer> map = new HashMap<>();

        List<Integer> list= new ArrayList<>();

        list.add(100);

         r1= map.put(11, 100);
        r1= map.put(11,100);
        r1=map.put(11,200);
        r1=map.put(10,50);

       for(Map.Entry<Integer,Integer>xyz:map.entrySet()){

           xyz.getKey();
           xyz.getValue();
       }




    }
}
