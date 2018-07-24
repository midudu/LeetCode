package graph;

import java.util.Queue;
import java.util.LinkedList;

class BFS {

    public static void BFSUsingAdjacentMatrix(AdjacencyMatrix adjacencyMatrix) {

        Integer[][] innerAdjacencyMatrix = adjacencyMatrix.getInnerAdjacencyMatrix();

        boolean[] hasVisited = new boolean[innerAdjacencyMatrix.length];

        for (int i = 1; i < hasVisited.length; i++) {
            BFSUsingAdjacentMatrixHelper(i, innerAdjacencyMatrix, hasVisited, adjacencyMatrix);
        }
    }

    private static void BFSUsingAdjacentMatrixHelper(int currentVertexIndex,
                                                     Integer[][] innerAdjacencyMatrix,
                                                     boolean[] hasVisited,
                                                     AdjacencyMatrix adjacencyMatrix) {

        if (hasVisited[currentVertexIndex]) {
            return;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(currentVertexIndex);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer index = queue.poll();
                if (!hasVisited[index]) {
                    hasVisited[index] = true;
                    System.out.println(adjacencyMatrix.getVertexName(index));
                }
                for (int j = 0; j < innerAdjacencyMatrix[index].length; j++) {
                    if (innerAdjacencyMatrix[index][j] != null && !hasVisited[j]) {
                        queue.offer(j);
                    }
                }
            }
        }
    }


    public static void BFSUsingAdjacentTable(AdjacencyTable adjacencyTable) {

        LinkedList<LinkedList<AdjacencyTable.Node>> innerAdjacencyTable
                = adjacencyTable.getInnerAdjacencyTable();

        boolean[] hasVisited = new boolean[innerAdjacencyTable.size()];

        for (int i = 1; i < hasVisited.length; i++) {
            BFSUsingAdjacentTableHelper(adjacencyTable, hasVisited,
                    i, innerAdjacencyTable);
        }
    }

    private static void BFSUsingAdjacentTableHelper(AdjacencyTable adjacencyTable, boolean[] hasVisited,
                                                    int currentIndex,
                                                    LinkedList<LinkedList<AdjacencyTable.Node>> innerAdjacencyTable) {

        if (hasVisited[currentIndex]) {
            return;
        }

        Queue<AdjacencyTable.Node> queue = new LinkedList<>();
        queue.offer(innerAdjacencyTable.get(currentIndex).get(0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AdjacencyTable.Node tempNode = queue.poll();
                if (!hasVisited[adjacencyTable.getIndex(tempNode.name)]) {
                    hasVisited[adjacencyTable.getIndex(tempNode.name)] = true;
                    System.out.println(tempNode.name);
                }

                int row = adjacencyTable.getIndex(tempNode.name);

                for (int j = 1; j < innerAdjacencyTable.get(row).size(); j++) {
                    int index = adjacencyTable.getIndex(
                            innerAdjacencyTable.get(row).get(j).name);
                    if (!hasVisited[index]) {
                        queue.offer(innerAdjacencyTable.get(row).get(j));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
/*
        String[] vertex = {"1", "2", "3", "4", "5", "6", "7"};

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(vertex);
        adjacencyMatrix.updateEdge("1", "2", 1);
        adjacencyMatrix.updateEdge("3", "1", 6);
        adjacencyMatrix.updateEdge("4", "1", 3);
        adjacencyMatrix.updateEdge("2", "3", 4);
        adjacencyMatrix.updateEdge("2", "4", 4);
        adjacencyMatrix.updateEdge("4", "3", 9);
        adjacencyMatrix.updateEdge("6", "2", 7);
        adjacencyMatrix.updateEdge("7", "6", 7);
        adjacencyMatrix.updateEdge("7", "4", 7);
        adjacencyMatrix.updateEdge("5", "7", 7);
        adjacencyMatrix.updateEdge("5", "6", 7);

        BFSUsingAdjacentMatrix(adjacencyMatrix);*/

        String[] vertex = {"1", "2", "3", "4", "5", "6", "7"};
        AdjacencyTable adjacencyTable = new AdjacencyTable(vertex);

        adjacencyTable.updateEdge("1", "2", 1);
        adjacencyTable.updateEdge("3", "1", 6);
        adjacencyTable.updateEdge("4", "1", 3);
        adjacencyTable.updateEdge("2", "3", 4);
        adjacencyTable.updateEdge("2", "4", 4);
        adjacencyTable.updateEdge("4", "3", 9);
        adjacencyTable.updateEdge("6", "2", 7);
        adjacencyTable.updateEdge("7", "6", 7);
        adjacencyTable.updateEdge("7", "4", 7);
        adjacencyTable.updateEdge("5", "7", 7);
        adjacencyTable.updateEdge("5", "6", 7);

        BFSUsingAdjacentTable(adjacencyTable);
    }
}