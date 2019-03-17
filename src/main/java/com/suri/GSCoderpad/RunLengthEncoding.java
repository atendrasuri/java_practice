package com.suri.GSCoderpad;/* Problem Name is &&& Run Length Encoding &&& PLEASE DO NOT REMOVE THIS LINE. */


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 **  * Instructions to candidate.
 **  *  1) Run this code in the REPL to observe its behaviour.
 **  *  2) Consider adding some additional tests in doTestsPass().
 **  *  3) Implement rle() correctly.
 **  *  4) If time permits, try to improve your implementation.
 **


 * Implement a run length encoding function.
 *
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * ""      -> ""
 *
 */
public class RunLengthEncoding {

  public static String rle(String input) {
    Map<Character,Integer> map= new LinkedHashMap<>();


    for(int i=0;i<input.length();i++){
      char c = input.charAt(i);
      if(map.containsKey(c)){
        map.put(c,map.get(c)+1);
      }else{
        map.put(c,1);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(Character c:map.keySet()){
      sb.append(c);
      sb.append(map.get(c));
    }
    return sb.toString();
  }



  public void doTestsPass(){
    System.out.println("a3".equals(rle("aaa")));
    System.out.println( "a3b2c1".equals(rle("aaabbc")));
  }


  public static void main(String[] args) throws InterruptedException     {
    RunLengthEncoding obj = new RunLengthEncoding();
    obj.doTestsPass();
  }
}