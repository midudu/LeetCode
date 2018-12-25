/*
Given the head of a graph, return a deep copy (clone) of the graph.
Each node in the graph contains a label (int) and a list
(List[UndirectedGraphNode]) of its neighbors.

There is an edge between the given node and each of the nodes in its neighbors.*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Definition for undirected graph.
class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {

        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class Solution {

    public static void main(String[] args) {

        UndirectedGraphNode A = new UndirectedGraphNode(0);
        UndirectedGraphNode B = new UndirectedGraphNode(1);
        UndirectedGraphNode C = new UndirectedGraphNode(2);

        A.neighbors.add(B);
        A.neighbors.add(C);

        B.neighbors.add(C);

        C.neighbors.add(C);

        UndirectedGraphNode newNode = new Solution().cloneGraph(A);

        System.out.println();
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return node;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();

        return cloneGraphHelper(node, hashMap);
    }

    private UndirectedGraphNode cloneGraphHelper(
            UndirectedGraphNode currentNode,
            HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap) {

        UndirectedGraphNode newNode = new UndirectedGraphNode(currentNode.label);
        hashMap.put(currentNode, newNode);

        for (int i = 0; i < currentNode.neighbors.size(); i++) {

            UndirectedGraphNode originalNode = currentNode.neighbors.get(i);

            if (hashMap.containsKey(originalNode)) {
                newNode.neighbors.add(hashMap.get(originalNode));
            } else {
                newNode.neighbors.add(cloneGraphHelper(originalNode, hashMap));
            }
        }

        return newNode;
    }
}