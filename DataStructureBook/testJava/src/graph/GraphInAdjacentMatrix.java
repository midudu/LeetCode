package graph;

import java.util.ArrayList;

public class GraphInAdjacentMatrix {

    private ArrayList<ArrayList<Integer>> adjacentMatrix
            = new ArrayList<>();

    public void addVertex() {

        if (adjacentMatrix.isEmpty()) {
            ArrayList<Integer> newRow = new ArrayList<>();
            newRow.add(-1);
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
        adjacentMatrix.add(newRow);
    }

    public void addEdge(int vertex1, int vertex2, int weight) {

        assert (vertex1 != vertex2);
        assert (vertex1 >=0 && vertex1 < adjacentMatrix.size());
        assert (vertex2 >=0 && vertex2 < adjacentMatrix.size());

        adjacentMatrix.get(vertex1).set(vertex2, weight);
        adjacentMatrix.get(vertex2).set(vertex1, weight);
    }

    public ArrayList<ArrayList<Integer>> getAdjacentMatrix() {

        return (ArrayList<ArrayList<Integer>>)this.adjacentMatrix.clone();
    }
}


class TestGraphInAdjacentMatrix {

    public static void main(String[] args) {

        GraphInAdjacentMatrix graph = new GraphInAdjacentMatrix();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0,1,7);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,8);
    }
}