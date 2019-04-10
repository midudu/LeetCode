/*
  For an undirected graph with tree characteristics, we can choose any node as
the root. The result graph is then a rooted tree. Among all possible rooted
trees, those with minimum height are called minimum height trees (MHTs). Given
such a graph, write a function to find all the MHTs and return a list of their
root labels.

Format
  The graph contains n nodes which are labeled from 0 to n - 1. You will be
given the number n and a list of undirected edges (each edge is a pair of labels).

  You can assume that no duplicate edges will appear in edges. Since all edges
are undirected, [0, 1] is the same as [1, 0] and thus will not appear together
in edges.

Example 1 :

        Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

         0
         |
         1
        / \
       2   3

        Output: [1]

Example 2 :

        Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

        0  1  2
         \ | /
           3
           |
           4
           |
           5

        Output: [3, 4]

Note:
  According to the definition of tree on Wikipedia: “a tree is an undirected
graph in which any two vertices are connected by exactly one path. In other
words, any connected graph without simple cycles is a tree.”

  The height of a rooted tree is the number of edges on the longest downward
path between the root and a leaf.
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {

        int n = 6;

        int[][] edges =
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        new Solution().findMinHeightTrees(n, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();

        if (n == 0) {
            return result;
        } else if (n == 1) {
            result.add(0);
            return result;
        }

        List<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            list.get(first).add(second);
            list.get(second).add(first);
        }

        HashSet<Integer> leftNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftNodes.add(i);
        }

        while (leftNodes.size() > 2) {

            HashSet<Integer> leaveNodes = new HashSet<>();

            for (int i = 0; i < list.size(); i++) {

                HashSet<Integer> relativeNodes = list.get(i);

                if (relativeNodes.size() == 1) {

                    leaveNodes.add(i);
                }
            }

            for (int leafNode : leaveNodes) {

                HashSet<Integer> relativeNodes = list.get(leafNode);

                int theRelativeNode = relativeNodes.iterator().next();
                list.get(theRelativeNode).remove(leafNode);

                relativeNodes.clear();
            }

            leftNodes.removeAll(leaveNodes);
        }

        result.addAll(leftNodes);

        return result;
    }
}