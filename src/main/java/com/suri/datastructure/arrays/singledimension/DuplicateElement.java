package com.suri.datastructure.arrays.singledimension;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DuplicateElement {

    public static void main(String[] args) {
        int arr[] ={10,20,30,19,20,10};

        findDuplicateElement(arr);

    }


    public static void findDuplicateElement(int arr[]) {




        Hashtable<Integer, Integer> hs = new Hashtable<>();

        for (int i = 0; i < arr.length; i++) {

            if (hs.containsKey(arr[i]) == false) {
                hs.put(arr[i], 1);
            } else {
                hs.put(arr[i], hs.get(arr[i]) + 1);
            }
        }

        Set<Integer> res = hs.keySet();


        for (Integer r : res) {

            if (hs.get(r) > 1) {
                System.out.println("duplicate element is " + r + "--->" + hs.get(r));
            }

        }


    }
}
