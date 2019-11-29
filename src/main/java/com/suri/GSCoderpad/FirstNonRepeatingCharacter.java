package com.suri.GSCoderpad;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findFirst() correctly.
 *  4) If time permits, try to improve the efficiency of your implementation
 */

public class FirstNonRepeatingCharacter {

  /**
  * char findFirst(String input) 
  * Finds the first character that does not repeat anywhere in the input string
  * Given "apple", the answer is "a"
  * Given "racecars", the answer is "e"
  * Given "ababdc", the answer is "d"
  **/        
  public static char findFirst(String input)
  {
    Map<Character, Integer> map= new LinkedHashMap<>();

    for(int i=0;i<input.length();i++){
      char c= input.charAt(i);
      if(map.containsKey(c)){
        map.put(c,map.get(c)+1);
      }else{
        map.put(c,1);
      }
    }
    for(Character c: map.keySet()){
      if(map.get(c)==1){
        return c;
      }
    }

    return ' ';
  }

  public static char findFirstUpdated(String input){

    if(input==null || input.length()==0){
      return ' ';
    }
    char[] charArr= input.toCharArray();
    int count[] = new int[26];

    for(int i=0;i<charArr.length;i++){
      count[charArr[i]-'a']++;
    }
    for (int i = 0; i < charArr.length; i++) {
      if (count[charArr[i]-'a'] == 1) {
        return charArr[i];
      }
    }

    return ' ';
  }

  /**
   * int doTestsPass()
   * Returns 1 if all tests pass. Otherwise returns 0.
   */    
  public static boolean doTestsPass()
  {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    String[] inputs = {"apple","racecars", "ababdc"};
    char[] outputs = {'a', 'e', 'd' };

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ )
    {
      result = result && findFirstUpdated(inputs[i]) == outputs[i];
      if(!result)
        System.out.println("Test failed for: " + inputs[i]);
      else
        System.out.println("Test passed for: " + inputs[i]);
    }
    return(result);
  }

  public static void main(String args[])
  {
    doTestsPass();
  }
}
