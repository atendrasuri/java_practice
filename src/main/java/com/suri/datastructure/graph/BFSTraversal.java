package com.suri.datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class BFSTraversal {
  public static void main(String[] args) {

    GraphTraversalBFS graphTraversalBFS = new GraphTraversalBFS(5);
    graphTraversalBFS.insertEdge(0, 1);
    graphTraversalBFS.insertEdge(0, 2);
    graphTraversalBFS.insertEdge(1, 2);
    graphTraversalBFS.insertEdge(2, 0);
    graphTraversalBFS.insertEdge(2, 3);
    graphTraversalBFS.insertEdge(3, 3);


    // print the adjacency list representation of
    // the above graph
    //graphTraversalBFS.printGraph(graphTraversalBFS.graph);
    graphTraversalBFS.BFS(graphTraversalBFS.graph, 2);

  }
}

class GraphTraversalBFS {

  class Graph {
    int v;
    LinkedList<Integer> adjListArray[];

    Graph(int v) {
      this.v = v;
      adjListArray = new LinkedList[v];

      for (int i = 0; i < v; i++) {
        adjListArray[i] = new LinkedList<>();
      }
    }
  }

  Graph graph;

  GraphTraversalBFS(int v) {
    graph = new Graph(v);
  }

  /**
   * helper method
   *
   * @param
   * @param src
   * @param des
   */

  public void insertEdge(int src, int des) {
    addEdge(graph, src, des);
  }

  public void addEdge(Graph graph, int src, int des) {


    graph.adjListArray[src].add(des);

  }

  public void printGraph(Graph graph) {

    for (int v = 0; v < graph.v; v++) {
      System.out.println();
      System.out.println(" " + v);


      System.out.print("head");
      for (Integer i : graph.adjListArray[v]) {

        System.out.print("-->" + i + " ");
      }
      System.out.println();

    }
  }

  /**
   *
   *
   */

  public void BFS(Graph graph, int s) {

    boolean visted[] = new boolean[graph.v];

    Queue<Integer> queue = new LinkedList<>();

    visted[s] = true;
    queue.add(s);
    while (!queue.isEmpty()) {
      Integer temp = queue.poll();
      System.out.println(temp + " ");

      Iterator<Integer> res = graph.adjListArray[temp].iterator();
      while (res.hasNext()) {
        int n = res.next();
        if (visted[n] != true) {
          visted[n] = true;
          queue.add(n);
        }
      }
    }
  }

  static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);

    while (!queue.isEmpty()) {

      int temp = queue.remove();
      if (vis[temp]) {
        continue;
      }
      vis[temp] = true;
      System.out.print(temp + " ");
      ArrayList<Integer> lst = list.get(temp);

      for (int i : lst) {
        queue.add(i);
      }

    }
  }
}
