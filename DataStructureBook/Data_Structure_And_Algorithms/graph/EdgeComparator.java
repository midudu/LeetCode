package graph;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

    public int compare(Edge o1, Edge o2) {

        return Integer.compare(o1.weight, o2.weight);
    }
}
