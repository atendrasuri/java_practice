package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class BalancedParenthesis {


    public static class Stack{


        char items[] = new char[100];
        int top=-1;

        public void push(char c){
            if(top==99){
                System.out.println("stack is full");
                return;
            }

            items[++top]=c;
        }

        public char pop(){
            if(top==-1){
                System.out.println("stack is empty");
                return '\0';
            }
            return items[top--];
        }

        public boolean isEmpty(){
            return (top==-1)?true:false;
        }
    }

    public boolean isMatchingpair(char c1, char c2){

        if(c1=='{' && c2== '}')
            return true;
        else if(c1=='[' && c2==']')
            return true;
        else if(c1=='(' && c2 ==')')
            return true;
        else
            return false;
    }

    public boolean areParenthesisBalanced(String exp){

        Stack st = new Stack();

        int n = exp.length();

        for(int i=0;i<n;i++){
            char c= exp.charAt(i);

            if(c=='[' || c=='{' || c=='('){
               st.push(c) ;
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }


}