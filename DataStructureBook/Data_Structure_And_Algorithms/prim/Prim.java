package prim;

import graph.Edge;
import graph.adjacentMatrix.UndigraphInAdjacentMatrix;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements the classical algorithm in finding Minimum-Spanning-Tree
 * (MST): the Prim algorithm.
 *
 * The basic theory is of the Prim algorithm is to add vertices in order. There
 * are two containers in the algorithm: one is to store the exisiting vertices
 * in the final result and another is to store the left vertices in the graph.
 *
 * At first, a vertex is added to the existing nodes list randomly. Then, follow
 * the operations as below until all the vertices in the graph are added to the
 * final result:
 *
 * 1. Find a vertex U from the existing nodes list and find a vertex V from the
 * left nodes list so that the weight between them is the smallest among all
 * the pairs;
 * 2. Add U to the existing nodes list;
 * 3. Remove V from the left nodes list.
 *
 */

public class Prim {

    public static void Prim(UndigraphInAdjacentMatrix graph, ArrayList<Edge> edges) {

        if (!edges.isEmpty()) {
            edges.clear();
        }

        ArrayList<ArrayList<Integer>> edgeTable = graph.getAdjacentMatrix();

        ArrayList<Integer> existingNodeList = new ArrayList<>();
        existingNodeList.add(0);

        LinkedList<Integer> leftNodeList = new LinkedList<>();
        for (int i = 1; i < edgeTable.size(); i++) {
            leftNodeList.add(i);
        }

        while (!leftNodeList.isEmpty()) {

            int minWeight = Integer.MAX_VALUE;
            int startIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < existingNodeList.size(); i++) {
                for (int j = 0; j < leftNodeList.size(); j++) {

                    int currentWeight = edgeTable.get(
                                    existingNodeList.get(i)).get(leftNodeList.get(j));

                    if (currentWeight == -1) {
                        continue;
                    }

                    if (currentWeight < minWeight) {
                        minWeight = currentWeight;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }

            edges.add(new Edge(existingNodeList.get(startIndex),
                    leftNodeList.get(endIndex), minWeight));
            existingNodeList.add(leftNodeList.get(endIndex));
            leftNodeList.remove(endIndex);
        }
    }
}

class TestPrim {

    public static void main(String[] args) {

        UndigraphInAdjacentMatrix graph = new UndigraphInAdjacentMatrix();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0,1,6);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,5);
        graph.addEdge(1,4,3);
        graph.addEdge(2,3,5);
        graph.addEdge(2,4,6);
        graph.addEdge(2,5,4);
        graph.addEdge(3,5,2);
        graph.addEdge(4,5,6);

        ArrayList<Edge> edges = new ArrayList<>();

        Prim.Prim(graph, edges);

        System.out.println();
    }
}
