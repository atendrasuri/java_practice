package com.suri.companyWise.HaloDoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SortenUrl {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int k = 1; k <= T; k++) {
      int n = Integer.parseInt(br.readLine());
      List<String> list = new ArrayList<>();
      int top = 0;
      for (int i = 0; i < n; i++) {

        String s = br.readLine();
        if (s.contains("top")) {
          top = Integer.parseInt(s.split("\\s+")[1]);
          Collections.sort(list);
          printMethod(list, top);
        } else {
          list.add(s);
        }

      }

    }

  }

  public static void printMethod(List<String> list, int top){


    Map<String, Integer> map = new LinkedHashMap<>();

    for (String s : list) {

      if (map.get(s) != null) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }


    Map<String, Integer> sorted = map.entrySet()
            .stream()
            .sorted((Map.Entry.<String, Integer>comparingByValue()
                    .reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    int count =0;

    for(String s:sorted.keySet()){

      System.out.println(s+" ");
      count++;
      if(count==top){
        break;
      }
    }

  }


}