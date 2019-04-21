package com.suri.datastructure.tree;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class IsValidBSTFromPreOrder {

    public static void main(String[] args) {

        int arr[]={3,2,1,5,4,6};

        int arr1[]= {40, 30, 35, 20, 80, 100};

        String result= isValidBSTFromPreOrder(arr1);

        System.out.println(result);

    }

    public static String isValidBSTFromPreOrder(int arr[]){

        int n= arr.length;

        int root= Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            if(arr[i]<root){
                return "NO";
            }

            while(!stack.isEmpty() && stack.peek()<arr[i]){
                root=stack.peek();
                stack.pop();
            }

            stack.push(arr[i]);
        }
        return "YES";
    }
}