package com.suri.java.vinit;

import static java.lang.Byte.MIN_VALUE;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Test extends Exam {

    private String level ="hard";

    public static void main(String[] args) {


        Test test = new Test();

        test.printLevel();

    }
}

class Exam{


    private String level ="Easy";

    public void printLevel(){
        System.out.println(level);
    }
}