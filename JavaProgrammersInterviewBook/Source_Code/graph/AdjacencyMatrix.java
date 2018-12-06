package graph;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class AdjacencyMatrix {

    private Integer[][] innerAdjacencyMatrix;
    private HashMap<String, Integer> vertexNameAndIndexTable;
	private HashMap<Integer, String> vertexIndexAndNameTable;

    public AdjacencyMatrix(String[] vertex) {

        innerAdjacencyMatrix = new Integer[vertex.length][vertex.length];
        vertexNameAndIndexTable = new HashMap<>();
		vertexIndexAndNameTable = new HashMap<>();

        for (int i = 0; i < vertex.length; i++) {
            vertexNameAndIndexTable.put(vertex[i], i);
			vertexIndexAndNameTable.put(i, vertex[i]);
        }
    }

    public void updateEdge(String srcEdge, String dstEdge, Integer weight) {

        Integer srcIndex = vertexNameAndIndexTable.get(srcEdge);
        Integer dstIndex = vertexNameAndIndexTable.get(dstEdge);

        innerAdjacencyMatrix[srcIndex][dstIndex] = weight;
    }


    public void deleteEdge(String srcEdge, String dstEdge) {

        Integer srcIndex = vertexNameAndIndexTable.get(srcEdge);
        Integer dstIndex = vertexNameAndIndexTable.get(dstEdge);

        innerAdjacencyMatrix[srcIndex][dstIndex] = null;
    }

    public Integer getWeight(String srcEdge, String dstEdge) {

        Integer srcIndex = vertexNameAndIndexTable.get(srcEdge);
        Integer dstIndex = vertexNameAndIndexTable.get(dstEdge);

        return innerAdjacencyMatrix[srcIndex][dstIndex];
    }
	
	public Integer[][] getInnerAdjacencyMatrix() {
		return innerAdjacencyMatrix;
	}
	
	public String getVertexName(Integer index) {
		
		return vertexIndexAndNameTable.get(index);
	}

    public static void main(String[] args) {

        String[] vertex = {"A", "B", "C", "D"};

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(vertex);
        adjacencyMatrix.updateEdge("A", "B", 1);
        adjacencyMatrix.updateEdge("A", "C", 6);
        adjacencyMatrix.updateEdge("B", "A", 3);
        adjacencyMatrix.updateEdge("C", "A", 4);
        adjacencyMatrix.updateEdge("C", "D", 9);
        adjacencyMatrix.updateEdge("D", "A", 7);


        System.out.println("haha");
    }
}