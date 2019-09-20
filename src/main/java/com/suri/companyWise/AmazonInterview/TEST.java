package com.suri.companyWise.AmazonInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TEST {

  public static void main(String[] args) {

    //double base = 50.6854;
   // double rate = .90877;
    //double howMuch = base * rate;
   /* Map<String, String> map1= new HashMap<>();

    Map<String, String> map2= new HashMap<>();
    Map<String, String> map3= new HashMap<>();
    Map<String, String> map4= new HashMap<>();

    map1.put("A","1");
    map1.put("B","2");

    map2.put("C","3");
    map2.put("D","4");

    map3.put("E","5");
    map3.put("F","6");

    map4.put("G","7");
    map4.put("H","8");*/







/*
    List<Map<String,String>> list = new ArrayList<>();

    list.add(map1);
    list.add(map2);
    list.add(map3);
    list.add(map4);


    List<String> ress = list.stream().flatMap(
            x -> x.values().
                    stream()).
            filter(y -> !y.equalsIgnoreCase("3")).
            collect(Collectors.toList());

    System.out.println(ress);*/


    /*List<List<String>> res = list.stream().map(
            map -> map.values().stream()
                    .filter(x -> !x.equalsIgnoreCase("5"))
                    .collect(Collectors.toList())

    ).collect(Collectors.toList());

    List<String> res1 = res.stream().flatMap(e -> e.stream()).collect(Collectors.toList());

    System.out.println(String.join(",", res1));
*/

    TrafficSignal[] signals = TrafficSignal.values();

    for (TrafficSignal signal : signals)
    {
      // use getter method to get the value
      System.out.println("name : " + signal.name() +
              " action: " + signal.getAction() );
    }

  }
}

enum TrafficSignal
{
  // This will call enum constructor with one
  // String argument
  RED(100), GREEN(200), ORANGE(300);

  // declaring private variable for getting values
  private int action;

  // getter method
  public int getAction()
  {
    return this.action;
  }

  // enum constructor - cannot be public or protected
  private TrafficSignal(int action)
  {
    this.action = action;
  }
}