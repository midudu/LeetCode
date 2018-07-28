package prim;

import graph.Edge;
import graph.GraphInAdjacentMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prim {

    public static void Prim(GraphInAdjacentMatrix graph, ArrayList<Edge> edges) {

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

        GraphInAdjacentMatrix graph = new GraphInAdjacentMatrix();

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
