package com.suri.java;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 14/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Test<INPUT> {

    private static String REGEX="\\Sto\\S|\\bo\\b";
    private static String INPUT="Nice to see you,to,be fine.";
    private static String REPLACE=",";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
    Matcher m = p.matcher(INPUT);
   INPUT= m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }

}

class A{
    A(String s){

    }
}

class B extends A {
    B(){
        this("Hello");
    }
    B(String s){
        super(s);
    }

}