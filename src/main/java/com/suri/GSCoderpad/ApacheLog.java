package com.suri.GSCoderpad;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findTopIpAddress() correctly.
 *  4) If time permits, try to improve your implementation.
 */

 class ApacheLog {

  /**
   * String findTopIpaddress(String[] lines)
   * Given an Apache log file, return IP address(es) which accesses the site most often.
   * 
   * Our log is in this format (Common Log Format). One entry per line and it starts with an IP address which accessed the site, 
   * followed by a whitespace.
   * 
   * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
   * 
   * Log file entries are passsed as an array.
   */

  public static String findTopIpaddress(String[] lines) {

      Map<String, Integer> map= new HashMap<>();

      for(String str:lines){

         String ip= str.split("-")[0].trim();
         if(map.containsKey(ip)){
             map.put(ip, map.get(ip)+1);
         }
         else{
             map.put(ip,1);
         }
      }

      int max=0;
      String res=null;
      for(String key:map.keySet()){

          if(map.get(key)>max){
              max= map.get(key);
              res=key;
          }
      }
      return res.trim();
    // TODO: Implement solution
    //return "10.0.0.1";
  }

  public static String findTopIpaddressImprove(String[] lines){
    if(lines.length==0){
      return "";
    }

    Map<String,Integer> map = new HashMap<>();
    for(String line:lines){
      String ip = line.split("-")[0].trim();
      map.put(ip,map.getOrDefault(ip,0)+1);
    }
    Map.Entry<String,Integer> entry =map.entrySet().stream().max(Map.Entry.comparingByValue()).get();

    return entry.getKey();

  }
  
  /**
   * boolean doTestsPass()
   * Returns true if the test passes. Otherwise returns false.
   */      
  public static boolean doTestsPass() {
    // TODO: improve the test
    String lines[] = new String[] {
        "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
        "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
        "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234" };
   // String result = findTopIpaddress(lines);

    String result = findTopIpaddressImprove(lines);
    
    if (result.equals("10.0.0.1")) {
      System.out.println("Test passed");
      return true;
    } else {
      System.out.println("Test failed");
      return false;
    }  
  }
  
  public static void main(String[] args) {
    doTestsPass();
  }
  
}