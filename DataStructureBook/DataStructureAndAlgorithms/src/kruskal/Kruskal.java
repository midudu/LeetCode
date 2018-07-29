package kruskal;

import graph.Edge;
import graph.adjacentMatrix.UndigraphInAdjacentMatrix;
import unionFindSet.UnionFindSet;
import graph.EdgeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * This class implements the classical algorithm in finding Minimum-Spanning-Tree
 * (MST): the Kruskal algorithm.
 *
 * The basic theory is of the Kruskal algorithm is to add edges into the final
 * result set in order by the weight of the edges. An edge with smaller weight
 * has higher priority. But if the new added edge can form a loop with the
 * existing edge, abandon the new edge.
 *
 * How to judge a loop is formed with the new edge added? In this algorithm, a
 * union-find-set is built to store several sets. At first, every vertex in
 * the graph has a root node of itself. If an edge is added to the MST result,
 * the two endpoints of the edge are unioned into one set. So we can judge if a
 * loop will be formed by judging if the two endpoints of the new edge belong
 * to the same set.
 */

public class Kruskal {

    /**
     * To implement the Kruskal algorithm.
     *
     * @param graph  a graph stored in adjacent matrix form
     * @param edges  a container to store the MST result
     */
    public static void Kruskal(UndigraphInAdjacentMatrix graph, ArrayList<Edge> edges) {

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
}

class TestKruskal {

    public static void main(String[] args) {

        UndigraphInAdjacentMatrix graph = new UndigraphInAdjacentMatrix();

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