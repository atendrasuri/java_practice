package com.suri.companyWise.google;

import java.util.Stack;

/**
 Given a stack, the task is to sort it such that the top of the stack has the greatest element.

 Input:
 The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer N denoting the size of the stack. Then in the next line are N space separated values which are pushed to the the stack.

 Output:
 For each test case output will be the popped elements from the sorted stack.
 Input:
 2
 3
 3 2 1
 5
 11 2 32 3 41

 Output:
 3 2 1
 41 32 11 3 2
 */
public class SortStack {
  public static void main(String[] args) {
    Stack<Integer> original = new Stack<>();
    original.push(11);
    original.push(25);
    original.push(4);
    original.push(9);
    original.push(20);
    original.push(31);

    System.out.println(sort(original));

  }

  public static Stack<Integer> sort(Stack<Integer> original)
  {
    if(original.size()>0){

      int x = original.pop();

      sort(original);
      sortUtil(original,x);

    }
    return original;
  }
  public static void sortUtil(Stack<Integer> original, int x){

    if(original.size()==0 || original.peek()<x){
      original.push(x);
      return;
    }
    int y = original.pop();
    sortUtil(original,x);
    original.push(y);

  }
}