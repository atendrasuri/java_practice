package com.suri.java.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class StreamExample {

    public static void main(String[] args) {


        List<String> months= Arrays.asList(new String[]{"January", "February","March","April","May","June"});
       months.forEach(l ->{
           l.toUpperCase();
           System.out.println("  "+l);
       });


    }
}