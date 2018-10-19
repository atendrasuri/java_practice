package com.suri.java.serialization;

import java.io.Serializable;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 23/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class CheckSerialVersionUID implements Serializable {

    int i;


    CheckSerialVersionUID(int _i){
        this.i=_i;
    }
    public void fun(){
        System.out.print(""+i);
    }

    public void fun1(){

    }

    public static void main(String[] args) {

        CheckSerialVersionUID obj= new CheckSerialVersionUID(10);
        System.out.println("");
        obj.fun();
    }
}
