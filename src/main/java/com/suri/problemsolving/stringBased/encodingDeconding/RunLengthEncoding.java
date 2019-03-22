package com.suri.problemsolving.stringBased.encodingDeconding;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
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

    public static String rlewithoutMap(String input) {


        StringBuilder sb = new StringBuilder();
        int j=0;
        for(int i=0;i<input.length();){
            int count=0;
            for( j=i;j<input.length();j++){
                if(input.charAt(i)== input.charAt(j)){
                    count++;
                }else{
                    break;
                }
            }
            i=j;
            sb.append(input.charAt(i-1));
            sb.append(count);
        }
        return sb.toString();
    }



    public void doTestsPass(){
        System.out.println("a3".equals(rle("aaa")));
        System.out.println( "a3b2c1".equals(rle("aaabbc")));
        System.out.println("a3".equals(rlewithoutMap("aaa")));
        System.out.println( "a3b2c1".equals(rlewithoutMap("aaabbc")));
    }


    public static void main(String[] args) throws InterruptedException     {
        com.suri.GSCoderpad.RunLengthEncoding obj = new com.suri.GSCoderpad.RunLengthEncoding();
        obj.doTestsPass();
    }
}