package com.suri.java.collection;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TreeMapDemo {

    public static void main(String[] args) throws IOException {


        ClassLoader classLoader = TreeMapDemo.class.getClassLoader();
        File file = new File(classLoader.getResource("sample-orders.csv").getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while(bufferedReader.readLine()!=null){
            String line = bufferedReader.readLine();
            System.out.println(line);
        }


        Map<Integer,String> map = new TreeMap<>();

        map.put(2,"Book");

        map.put(12,"Book"); map.put(22,"Book"); map.put(32,"Book"); map.put(42,"Book"); map.put(52,"Book");
        map.put(21,"Book"); map.put(31,"Book"); map.put(41,"Book"); map.put(56,"Book"); map.put(73,"Book");
        SortedMap<Integer, String> result = ((TreeMap<Integer, String>) map).subMap(10, 42);


        for(Map.Entry<Integer, String> res1:result.entrySet()){
            System.out.println(res1.getKey()+"--->"+res1.getValue());

        }



    }
}
