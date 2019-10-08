package com.suri.datastructure.graph;

import java.util.ArrayList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DetectCycleInDirectedGraph {
  public static void main(String[] args) {

    int nos = 5;
    boolean vis[] = new boolean[nos];

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(0);
    list1.add(1);
    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(2);
    list3.add(3);
    ArrayList<Integer> list4 = new ArrayList<>();
    list4.add(3);
    list4.add(2);

    list.add(list1);
    list.add(list2);
    list.add(list3);
    list.add(list4);
    System.out.println(isCyclic(list,4));

  }

  static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
  {
    boolean visited[] = new boolean[V];
    boolean explored[] = new boolean[V];

    for(int i=0;i<V;i++){
      if(!visited[i]){
        if(dfsUtil(i,list,visited,explored)){
          return true;
        }
      }
    }
    return false;
  }

  static boolean dfsUtil(int src, ArrayList<ArrayList<Integer>> list, boolean visited[], boolean explored[] ){
    visited[src]= true;
    explored[src]=true;

    for(int i=0;i<list.get(src).size();i++){
      int temp = list.get(src).get(i);
      if(explored[temp]){
        return true;
      }
      if(visited[temp]){
        continue;
      }

      if(dfsUtil(temp,list,visited,explored )){
        return true;
      }
    }
    explored[src]=false;
    return false;
  }
}