package com.suri.datastructure.stacks;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an absolute path for a file (Unix-style), simplify it. Note that absolute path always begin with ‘/’ ( root directory ), a dot in path represent current directory and double dot represents parent directory.
 * <p>
 * Examples:
 * <p>
 * "/a/./"   --> means stay at the current directory 'a'
 * "/a/b/.." --> means jump to the parent directory
 * from 'b' to 'a'
 * "////"    --> consecutive multiple '/' are a  valid
 * path, they are equivalent to single "/".
 * <p>
 * Input : /home/
 * Output : /home
 * <p>
 * Input : /a/./b/../../c/
 * Output : /c
 * <p>
 * Input : /a/..
 * Output:/
 * <p>
 * Input : /a/../
 * Output : /
 * <p>
 * Input : /../../../../../a
 * Output : /a
 * <p>
 * Input : /a/./b/./c/./d/
 * Output : /a/b/c/d
 * <p>
 * Input : /a/../.././../../.
 * Output:/
 * <p>
 * Input : /a//b//c//////d
 * Output : /a/b/c/d
 */
public class SimplifyDirectoryPath {

  public static void main(String[] args) {
    // absolute path which we have to simplify.
    String str = new String("/a/./b/../../c/");
    String res = simplifyPath(str);
    System.out.println(res);

  }

  public static String simplifyPath(String path) {

    if (path.isEmpty()) {
      return null;
    }

    int n = path.length();

    Stack<String> stack = new Stack<>();
    String res = "";
    res += "/";

    for (int i = 0; i < n; i++) {
// we will clear the temporary String
      // every time to accomodate new directory
      // name or command.
      // dir will contain "a", "b", "..", ".";
      String dir = "";

      // skip all the multiple '/' Eg. "/////""
      while (i < n && path.charAt(i) == '/') {

        i++;
      }
      // stores directory's name("a", "b" etc.)
      // or commands("."/"..") into dir
      while (i < n && path.charAt(i) != '/') {
        dir += path.charAt(i);
        i++;
      }

      // if dir has ".." just pop the topmost
      // element if the Stack is not empty
      // otherwise ignore.
      if (dir.equals("..") == true) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } // if dir has "." then simply continue
      // with the process.
      else if (dir.equals(".") == true) {
        continue;
      } // pushes if it encounters directory's
      // name("a", "b").
      else if (dir.length() != 0) {
        stack.push(dir);
      }
    }

    // a temporary Stack (st1) which will contain
    // the reverse of original Stack(st).
    Stack<String> stack1 = new Stack<String>();
    while (!stack.empty()) {

      stack1.push(stack.pop());
      // st.pop();
    }


    // the st1 will contain the actual res.
    while (!stack1.empty()) {

      // if it's the last element no need
      // to append "/"
      if (stack1.size() != 1)
        res += (stack1.pop() + "/");
      else
        res += stack1.pop();

      // st1.pop();
    }
    return res;


  }
}