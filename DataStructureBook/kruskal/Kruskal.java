package kruskal;

import graph.Edge;
import graph.GraphInAdjacentMatrix;
import unionFindSet.UnionFindSet;
import graph.EdgeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskal {

    public static void Kruskal(GraphInAdjacentMatrix graph, ArrayList<Edge> edges) {

        if (!edges.isEmpty()) {
            edges.clear();
        }

        ArrayList<ArrayList<Integer>> edgeTable = graph.getAdjacentMatrix();

        PriorityQueue<Edge> edgePriorityQueue
                = new PriorityQueue<Edge>(new EdgeComparator());
        for (int row = 0; row < edgeTable.size(); row++) {
            for (int col = row + 1; col < edgeTable.get(row).size(); col++) {

                int currentWeight = edgeTable.get(row).get(col);
                if (currentWeight == -1) {
                    continue;
                }

                edgePriorityQueue.add(new Edge(row, col, currentWeight));
            }
        }

        UnionFindSet unionFindSet = new UnionFindSet(edgeTable.size());

        while (!edgePriorityQueue.isEmpty()) {

            Edge currentEdge = edgePriorityQueue.poll();

            int startIndex = currentEdge.getStartIndex();
            int endIndex = currentEdge.getEndIndex();

            int root1 = unionFindSet.find(startIndex);
            int root2 = unionFindSet.find(endIndex);

            if (root1 == root2) {
                continue;
            }

            unionFindSet.union(root1, root2);
            edges.add(currentEdge);
        }
    }

    private static int rootIndex(int[] unionFindSet, int index) {

        if (unionFindSet[index] == index) {
            return index;
        } else {
          return rootIndex(unionFindSet, unionFindSet[index]);
        }
    }
}

class TestKruskal {

    public static void main(String[] args) {

        GraphInAdjacentMatrix graph = new GraphInAdjacentMatrix();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(1,2,6);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,5);
        graph.addEdge(2,3,5);
        graph.addEdge(2,5,3);
        graph.addEdge(3,4,5);
        graph.addEdge(3,5,6);
        graph.addEdge(3,6,4);
        graph.addEdge(4,6,2);
        graph.addEdge(5,6,6);

        ArrayList<Edge> edges = new ArrayList<>();

        Kruskal.Kruskal(graph, edges);

        System.out.println();
    }
}