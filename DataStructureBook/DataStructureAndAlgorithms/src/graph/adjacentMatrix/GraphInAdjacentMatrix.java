package graph.adjacentMatrix;

import java.util.ArrayList;

/**
 * This class is an abstract class which is to store a graph in adjacent matrix
 * form.
 * <p>
 * The difference between digraph and undigraph is the method of {@code addEdge}.
 */
abstract public class GraphInAdjacentMatrix {

    /**
     * The adjacent matrix of the graph
     */
    protected ArrayList<ArrayList<Integer>> adjacentMatrix
            = new ArrayList<>();

    /**
     * To add vertex to the graph
     */
    public void addVertex() {

        if (adjacentMatrix.isEmpty()) {
            ArrayList<Integer> newRow = new ArrayList<>();
            newRow.add(0);
            adjacentMatrix.add(newRow);

            return;
        }

        for (int row = 0; row < adjacentMatrix.size(); row++) {

            ArrayList<Integer> tempRow = adjacentMatrix.get(row);
            tempRow.add(-1);
        }

        ArrayList<Integer> newRow
                = new ArrayList<Integer>(adjacentMatrix.size() + 1);
        for (int i = 0; i < adjacentMatrix.size() + 1; i++) {
            newRow.add(-1);
        }
        newRow.set(adjacentMatrix.size(), 0);
        adjacentMatrix.add(newRow);
    }

    /**
     * To get the adjacent matrix of the current graph.
     *
     * @return the adjacent matrix of the current graph
     */
    public ArrayList<ArrayList<Integer>> getAdjacentMatrix() {

        return (ArrayList<ArrayList<Integer>>) this.adjacentMatrix.clone();
    }

    /**
     * To add an edge in the graph.
     *
     * @param startVertex the index of one of the end point of the edge
     * @param endVertex   the index of another end point of the edge
     * @param weight      the weight of the edge
     */
    abstract void addEdge(int startVertex, int endVertex, int weight);
}
