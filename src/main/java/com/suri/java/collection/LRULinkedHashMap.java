package com.suri.java.collection;

import java.util.LinkedHashMap;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LRULinkedHashMap {

    public static void main(String args[]){
        String v=null;

        LinkedHashMap <Integer,String>accessOrder= new LinkedHashMap(16,0.75f,true);


        accessOrder.put (1,"a");
        accessOrder.put (3,"c");
        accessOrder.put (2,"b");
        v = accessOrder.get(1);


        System.out.println(v);
        System.out.println(accessOrder);



    }
}
