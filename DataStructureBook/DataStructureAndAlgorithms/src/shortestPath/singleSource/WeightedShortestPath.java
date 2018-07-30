package shortestPath.singleSource;

import graph.adjacentMatrix.DigraphInAdjacentMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This class implements the algorithm of finding the shortest path from a
 * single source in a weighted graph.
 * <p>
 * If all the values of weight are positive, then Dijkstra algorithm is a
 * proper method; If some values are negative, we should combine Dijkstra
 * algorithm with exhaust algorithm to find the shortest paths.
 */
public class WeightedShortestPath {

    /**
     * To find the shortest paths for every other node in the current graph
     * from the single source node. But note that there exists some negative
     * weight values.
     *
     * @param graph      the current graph
     * @param startIndex the index of the start node
     * @param paths      a container to store all the shortest paths from the
     *                   single source node to every other node
     */
    public static void findShortestPathOfNegativeWeight(
            DigraphInAdjacentMatrix graph, int startIndex,
            HashMap<Integer, String> paths) {

        ArrayList<ArrayList<Integer>> edgeTable = graph.getAdjacentMatrix();

        int[] lastNode = new int[edgeTable.size()];
        initLength(lastNode);
        lastNode[startIndex] = startIndex;

        int[] distances = new int[edgeTable.size()];
        initLength(distances);
        distances[startIndex] = 0;

        HashSet<Integer> S = new HashSet<>();
        S.add(startIndex);

        int currentIndex = startIndex;

        while (S.size() != edgeTable.size()) {

            for (int i = 0; i < edgeTable.get(currentIndex).size(); i++) {

                if (S.contains(i)) {
                    continue;
                }

                int currentWeight = edgeTable.get(currentIndex).get(i);

                if (currentWeight == -1) {
                    continue;
                }

                if (distances[currentIndex] + currentWeight < distances[i]) {
                    lastNode[i] = currentIndex;
                    distances[i] = distances[currentIndex] + currentWeight;
                }
            }

            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < distances.length; i++) {
                if (S.contains(i)) {
                    continue;
                }
                if (distances[i] < minLength) {
                    currentIndex = i;
                    minLength = distances[i];
                }
            }

            S.add(currentIndex);
        }

        paths.put(startIndex, String.valueOf(startIndex));
        collectPath(lastNode, paths);
    }

    /**
     * This function is an auxiliary function for the
     * {@code findShortestPathOfNegativeWeight} method.The aim is to initialize
     * an array with the maximum value elements.
     *
     * @param distances the array to be initialized
     */
    private static void initLength(int[] distances) {

        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * To form paths from the {@code lastNode} information.
     *
     * @param lastNode an array to store the index of the last node in the
     *                 shortest paths
     * @param paths    a container to store all the shortest paths from the
     *                 single source node to every other node
     */
    private static void collectPath(int[] lastNode, HashMap<Integer, String> paths) {

        for (int i = 0; i < lastNode.length; i++) {

            paths.put(i, collectPathHelper(i, lastNode, paths));
        }
    }

    /**
     * This function is an auxiliary function for the {@code collectPath} method.
     * The aim is to form the shortest paths recursively.
     *
     * @param index    the current node to be found path
     * @param lastNode an array to store the index of the last node in the
     *                 shortest paths
     * @param paths    a container to store all the shortest paths from the
     *                 single source node to every other node
     * @return a string which represent the shortest path from the source node
     * to the current node
     */
    private static String collectPathHelper(int index, int[] lastNode,
                                            HashMap<Integer, String> paths) {

        if (paths.containsKey(index)) {
            return paths.get(index);
        } else {
            return collectPathHelper(lastNode[index], lastNode, paths)
                    + "->" + String.valueOf(index);
        }
    }

    /**
     * To find the shortest paths for every other node in the current graph
     * from the single source node. All the weight values are positive.
     *
     * @param graph      the current graph
     * @param startIndex the index of the start node
     * @param paths      a container to store all the shortest paths from the
     *                   single source node to every other node
     */
    public static void findShortestPathOfPositiveWeight(
            DigraphInAdjacentMatrix graph, int startIndex,
            HashMap<Integer, String> paths) {

        ArrayList<ArrayList<Integer>> edgeTable = graph.getAdjacentMatrix();

        HashSet<Integer> S = new HashSet<>();
        S.add(startIndex);

        HashSet<Integer> V = new HashSet<>();
        for (int i = 0; i < edgeTable.size(); i++) {
            V.add(i);
        }
        V.remove(startIndex);

        int[] lastNode = new int[edgeTable.size()];
        initLength(lastNode);
        lastNode[startIndex] = startIndex;

        int[] length = new int[edgeTable.size()];
        initLength(length);
        length[startIndex] = 0;

        while (S.size() != edgeTable.size()) {

            int minWeight = Integer.MAX_VALUE;
            int nextIndex = 0;

            Iterator<Integer> iteratorV = V.iterator();
            while (iteratorV.hasNext()) {

                int indexV = iteratorV.next();

                Iterator<Integer> iteratorS = S.iterator();
                while (iteratorS.hasNext()) {

                    int indexS = iteratorS.next();

                    int currentWeight = edgeTable.get(indexS).get(indexV);
                    if (currentWeight == -1) {
                        continue;
                    }

                    currentWeight += length[indexS];
                    if (currentWeight < length[indexV]) {
                        lastNode[indexV] = indexS;
                        length[indexV] = currentWeight;
                    }

                    if (currentWeight < minWeight) {
                        minWeight = currentWeight;
                        nextIndex = indexV;
                    }
                }
            }

            S.add(nextIndex);
            V.remove(nextIndex);
        }

        paths.put(startIndex, String.valueOf(startIndex));
        collectPath(lastNode, paths);
    }
}

class TestWeightedShortestPath {

    public static void main(String[] args) {

        DigraphInAdjacentMatrix graph = new DigraphInAdjacentMatrix();

        for (int i = 0; i < 7; i++) {
            graph.addVertex();
        }

        graph.addEdge(2, 0, 4);
        graph.addEdge(2, 5, 5);
        graph.addEdge(0, 3, 1);
        graph.addEdge(0, 1, 2);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 5, 8);
        graph.addEdge(1, 3, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 6, 4);
        graph.addEdge(4, 6, 6);
        graph.addEdge(6, 5, 1);

        HashMap<Integer, String> paths = new HashMap<>();
        WeightedShortestPath.findShortestPathOfPositiveWeight(graph, 2, paths);

        for (int i = 0; i < 7; i++) {

            System.out.println(paths.get(i));
        }
    }
}
