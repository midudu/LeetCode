package graph.adjacentMatrix;

/**
 * This class is to store an undigraph in adjacent matrix form.
 */

public class DigraphInAdjacentMatrix extends GraphInAdjacentMatrix{

    /**
     * To add an edge in the graph.
     *
     * @param startVertex the index of one of the end point of the edge
     * @param endVertex the index of another end point of the edge
     * @param weight  the weight of the edge
     */
    @Override
    public void addEdge(int startVertex, int endVertex, int weight) {

        assert (startVertex != endVertex);
        assert (startVertex >= 0 && startVertex < adjacentMatrix.size());
        assert (endVertex >= 0 && endVertex < adjacentMatrix.size());

        adjacentMatrix.get(startVertex).set(endVertex, weight);
    }

}
