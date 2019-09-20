package com.suri.companyWise.AmazonInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TanMoy1 {
  public static void main(String[] args) {

    List<String> list1= new ArrayList<>();
    list1.add("p1");
    list1.add("1");
    list1.add("2");
    List<String> list2 = new ArrayList<>();
    list2.add("p2");
    list2.add("2");
    list2.add("1");

    List<List<String>> items = new ArrayList<>();
    items.add(list1);
    items.add(list2);

    TanMoy1 tonmoy = new TanMoy1();
    //tonmoy.fetchItemsToDisplay(items,0,0,1,0);
    System.out.println(tonmoy.fetchItemsToDisplay(items,0,0,1,0));

  }

  public  List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {

    List<String> result = new ArrayList<>();
    Collections.sort(items,new CustomComparator());
    System.out.println(items);

    result.add(items.get(pageNumber).get(itemPerPage-1));

return result;
  }
}
class CustomComparator implements Comparator<List<String>>
{
  @Override
  public int compare(List<String> o1,
                     List<String> o2)
  {
    String firstString_o1 = o1.get(1);
    String firstString_o2 = o2.get(1);
    return firstString_o1.compareTo(firstString_o2);
  }
}
