/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites,
for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
is it possible for you to finish all courses?

        Example 1:

        Input: 2, [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.
        Example 2:

        Input: 2, [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should
        also have finished course 1. So it is impossible.
        Note:

The input prerequisites is a graph represented by a list of edges,
not adjacency matrices. Read more about how a graph is represented.

You may assume that there are no duplicate edges in the input prerequisites.*/


import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean canFinish(int n, int[][] prerequisites) {

        if (n <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] pair : prerequisites) {
            edges.get(pair[0]).add(pair[1]);
        }

        return !isCyclic(edges);
    }

    private boolean isCyclic(List<ArrayList<Integer>> edges) {

        boolean[] hasChecked = new boolean[edges.size()];
        boolean[] hasVisitedInCurrentPath = new boolean[edges.size()];

        for (int i = 0; i < edges.size(); i++) {

            if (!hasChecked[i]) {

                if (isCyclicHelper(i, edges, hasChecked, hasVisitedInCurrentPath)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclicHelper(
            int currentNode,
            List<ArrayList<Integer>> edges,
            boolean[] hasChecked,
            boolean[] hasVisitedInCurrentPath) {

        if (hasVisitedInCurrentPath[currentNode]) {
            return true;
        }

        if (hasChecked[currentNode]) {
            return false;
        }


        hasChecked[currentNode] = true;
        hasVisitedInCurrentPath[currentNode] = true;

        for (Integer edge : edges.get(currentNode)) {

            if (isCyclicHelper(edge, edges, hasChecked, hasVisitedInCurrentPath)) {
                return true;
            }
        }

        hasVisitedInCurrentPath[currentNode] = false;
        return false;
    }
}