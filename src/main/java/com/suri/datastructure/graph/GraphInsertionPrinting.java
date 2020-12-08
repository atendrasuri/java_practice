package com.suri.datastructure.graph;

import java.util.LinkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class GraphInsertionPrinting {

    public static void main(String[] args) {

        GraphInsertion graphInsertion = new GraphInsertion(5);
        graphInsertion.addEdge(0, 1);
        graphInsertion.addEdge(0, 4);
        graphInsertion.addEdge(1, 2);
        graphInsertion.addEdge(1, 3);
        graphInsertion.addEdge(1, 4);
        graphInsertion.addEdge(2, 3);
        graphInsertion.addEdge(3, 4);

        // print the adjacency list representation of
        // the above graph
        graphInsertion.printGraph();


    }
}

class GraphInsertion {


    class Graph {

        int V;
        LinkedList<Integer> adjListArray[];

        Graph(int v) {
            this.V = v;

            adjListArray = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }


    }

    Graph graph;

    GraphInsertion(int v) {

        graph = new Graph(v);
    }

    public void addEdge(int src, int dest) {

        graph.adjListArray[src].add(dest);
       // graph.adjListArray[dest].add(src);

    }


    public void printGraph() {

        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }
}