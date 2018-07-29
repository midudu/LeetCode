package graph;

import java.util.Comparator;

public class Edge {

    int startIndex;
    int endIndex;
    int weight;

    public Edge(int startIndex, int endIndex, int weight) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}

