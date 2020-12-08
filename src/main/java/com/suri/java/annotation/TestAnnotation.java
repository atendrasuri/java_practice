package com.suri.java.annotation;

import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        TestAnnotation testAnnotation = new TestAnnotation();

       Method m = testAnnotation.getClass().getMethod("myTest");
        System.out.println(m.getAnnotation(MyAnnotation.class).hello());
        testAnnotation.myTest();

    }
    @MyAnnotation(hello="Atendra")
    public void myTest(){

    }
}
