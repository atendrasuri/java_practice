package com.suri.datastructure.stack;

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


    public static class Stack {

        char items[] = new char[100];
        int top = -1;


        public void push(char c) {

            if (top == 99) {
                System.out.println("stack is full");
                return;
            }
            items[++top] = c;
        }

        public char pop() {
            if (top == -1) {
                System.out.println("stack is empty");
                return '\0';
            }
            return items[top--];
        }

        public boolean isEmpty() {
            return (top == -1) ? true : false;
        }
    }

    public boolean isMatchingPair(char op1, char op2) {
        if (op1 == '[' && op2 == ']')
            return true;
        else if (op1 == '(' && op2 == ')')
            return true;
        else if (op1 == '{' && op2 == '}')
            return true;
        else
            return false;
    }


    public boolean areParenthesisBalanced(String exp) {
        int n = exp.length();

        Stack st = new Stack();
        for (int i = 0; i < n; i++) {
            char c = exp.charAt(i);

            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                if (st.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(st.pop(), c))
                    return false;
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String exp ="{{{[4]}}}[";

        BalancedParenthesis obj= new BalancedParenthesis();
        System.out.println(obj.areParenthesisBalanced(exp));


    }


}