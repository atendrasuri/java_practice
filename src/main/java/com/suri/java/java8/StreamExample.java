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


        /*List<String> months= Arrays.asList(new String[]{"January", "February","March","April","May","June"}); */

        List<Integer>lst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        /*Runnable r = ()-> System.out.println("hello") ;

        Thread t = new Thread(r);

        t.start();
*/




        /*months.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

*/
        System.out.println(
        lst.stream()
                .filter(e->e%2==0)
                .map(e->e*2)
                .reduce(Integer::sum));

    }
}