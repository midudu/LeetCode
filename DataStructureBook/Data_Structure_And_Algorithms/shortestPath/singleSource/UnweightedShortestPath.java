package shortestPath.singleSource;

import graph.adjacentMatrix.UndigraphInAdjacentMatrix;

import java.util.*;

/**
 * This class implements the algorithm of finding the shortest path from one
 * node to every other node in a unweighted graph.
 * <p>
 * The basic theory of this algorithm is BFS.
 */

public class UnweightedShortestPath {

    /**
     * The implementation of finding the shortest path from one node to every
     * other node in a unweighted graph.
     *
     * @param graph      an unweighted graph
     * @param startIndex the index of the start node
     * @param paths      the paths from the start node to other nodes in the
     *                   graph
     */
    public static void findShortestPath(UndigraphInAdjacentMatrix graph,
                                        int startIndex,
                                        HashMap<Integer, String> paths) {

        ArrayList<ArrayList<Integer>> edgeTable
                = graph.getAdjacentMatrix();

        if (startIndex < 0 || startIndex >= edgeTable.size()) {
            throw new IndexOutOfBoundsException();
        }

        boolean[] hasVisited = new boolean[edgeTable.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);
        hasVisited[startIndex] = true;
        paths.put(startIndex, String.valueOf(startIndex));

        while (!queue.isEmpty()) {

            Integer currentIndex = queue.poll();

            for (int i = 0; i < edgeTable.get(currentIndex).size(); i++) {
                if (edgeTable.get(currentIndex).get(i) == -1
                        || hasVisited[i] == true) {
                    continue;
                }

                queue.offer(i);
                hasVisited[i] = true;
                paths.put(i, paths.get(currentIndex) + "->" + String.valueOf(i));
            }
        }
    }
}


class TestUnweightedShortestPath {

    public static void main(String[] args) {

        UndigraphInAdjacentMatrix graph = new UndigraphInAdjacentMatrix();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 7, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 7, 1);
        graph.addEdge(5, 6, 1);

        HashMap<Integer, String> paths = new HashMap<>();
        UnweightedShortestPath.findShortestPath(graph, 1, paths);

        Collection<String> value = paths.values();
        Iterator iterator = value.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
