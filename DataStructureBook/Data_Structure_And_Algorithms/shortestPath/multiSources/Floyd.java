package shortestPath.multiSources;

import graph.adjacentMatrix.DigraphInAdjacentMatrix;
import graph.adjacentMatrix.UndigraphInAdjacentMatrix;

import java.util.*;

/**
 *
 */
public class Floyd {

    public static void floyd(UndigraphInAdjacentMatrix graph,
                             ArrayList<HashMap<Integer, String>> paths) {

        ArrayList<ArrayList<Integer>> edgeTable
                = graph.getAdjacentMatrix();

        int[][] lastNode = new int[edgeTable.size()][edgeTable.size()];
        initializeLastNode(lastNode, edgeTable);

        int[][] lengthTable = new int[edgeTable.size()][edgeTable.size()];
        initializeLength(lengthTable, edgeTable);

        floydHelper(lastNode, lengthTable, edgeTable.size());

        convertToPaths(lastNode, paths);
    }

    private static void floydHelper(int[][] lastNode,
                             int[][] lengthTable, int size) {

        for (int k = 0; k < size; k++) {

            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size; j++) {

                    if (i == j) {
                        continue;
                    }

                    int newLength = lengthTable[i][k] + lengthTable[k][j];
                    if (newLength < 0) {  // overflow
                        continue;
                    }

                    if (newLength < lengthTable[i][j]) {
                        lengthTable[i][j] = newLength;
                        lastNode[i][j] = k;
                    }
                }
            }
        }
    }

    private static void initializeLastNode(
            int[][] lastNode,  ArrayList<ArrayList<Integer>> edgeTable) {

        for (int i = 0; i < edgeTable.size(); i++) {

            for (int j = 0; j < edgeTable.size(); j++) {

                if (edgeTable.get(i).get(j) != -1) {
                    lastNode[i][j] = i;

                } else {
                    lastNode[i][j] = -1;
                }
            }

        }
    }

    private static void initializeLength(int[][] lengthTable,
                                         ArrayList<ArrayList<Integer>> edgeTable) {

        for (int i = 0; i < lengthTable.length; i++) {
            for (int j = 0; j < lengthTable[i].length; j++) {

                int currentWeight = edgeTable.get(i).get(j);

                lengthTable[i][j]
                        = currentWeight == -1 ? Integer.MAX_VALUE : currentWeight;
            }
        }
    }

    private static void convertToPaths(int[][] lastNode,
                                       ArrayList<HashMap<Integer, String>> paths) {

        for (int i = 0; i < lastNode.length; i++) {

            HashMap<Integer, String> currentPaths = new HashMap<>();
            currentPaths.put(i, String.valueOf(i));

            collectPath(lastNode[i], currentPaths);

            paths.add(currentPaths);
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
}

class TestFloyd {

    public static void main(String[] args) {

        UndigraphInAdjacentMatrix graph = new UndigraphInAdjacentMatrix();
        generateGraph(graph);

        ArrayList<HashMap<Integer, String>> paths = new ArrayList<>();
        Floyd.floyd(graph, paths);

        for (HashMap<Integer, String> currentPaths:paths) {

            for (int i = 0; i < graph.getAdjacentMatrix().size(); i++) {
                System.out.println(currentPaths.getOrDefault(i, ""));
            }

            System.out.println();
        }
    }

    private static void generateGraph(UndigraphInAdjacentMatrix graph) {

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
    }
}
