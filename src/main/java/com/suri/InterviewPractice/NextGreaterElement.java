package com.suri.InterviewPractice;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int arr[] = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};

        NGE(arr);


    }

    public static void NGE(int arr[]) {
        Stack<Integer> st = new Stack<Integer>();
        int n = arr.length;
        int next, element;

        st.push(arr[0]);

        for (int i = 1; i < n; i++) {

            next = arr[i];

            if (st.empty() == false) {
                element = st.pop();


                while (element < next) {
                    System.out.println("" + element + "--->" + next);

                    if (st.empty() == true) {
                        break;
                    }
                    element = st.pop();
                }

                if (element > next) {
                    st.push(element);
                }

            }
            st.push(next);

        }

        while(st.empty()==false)
        {
            element=st.pop();
            next=-1;
            System.out.println(""+element+"--->"+next);
        }


    }
}