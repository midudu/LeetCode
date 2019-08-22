/*
  There are a total of n courses you have to take, labeled from 0 to n-1.

  Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]

  Given the total number of courses and a list of prerequisite pairs, is it
possible for you to finish all courses?

Example 1:

        Input: 2, [[1,0]]
        Output: true

        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.

Example 2:

        Input: 2, [[1,0],[0,1]]
        Output: false

        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course
        0 you should also have finished course 1. So it is impossible.

Note:
  The input prerequisites is a graph represented by a list of edges, not
adjacency matrices. Read more about how a graph is represented.
  You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.HashSet;

class Solution {

    public static void main(String[] args) {

        int[][] pre = {{1, 0}, {0, 1}, {1,2}};
        System.out.println(new Solution().canFinish(3, pre));
    }

    public boolean canFinish(int n, int[][] prerequisites) {

        if (n <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        HashSet<Integer>[] lastLessons = new HashSet[n];
        for (int i = 0; i < n; i++) {
            lastLessons[i] = new HashSet<Integer>();
        }

        for (int[] pre: prerequisites) {
            lastLessons[pre[0]].add(pre[1]);
        }

        return !hasCycle(lastLessons);
    }

    private boolean hasCycle(HashSet<Integer>[] lastLessons) {

        boolean[] noCycleFromCurrentNode = new boolean[lastLessons.length];

        for (int i = 0; i < lastLessons.length; i++) {
            if (hasCycle(lastLessons, noCycleFromCurrentNode, i, new HashSet<>())) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(HashSet<Integer>[] lastLessons,
                             boolean[] noCycleFromCurrentNode, int startIndex,
                             HashSet<Integer> existingNodes) {

        if (noCycleFromCurrentNode[startIndex]) {
            return false;
        }
        if (existingNodes.contains(startIndex)) {
            return true;
        }

        existingNodes.add(startIndex);
        for (int node : lastLessons[startIndex]) {
            if (hasCycle(lastLessons, noCycleFromCurrentNode, node, existingNodes)) {
                return true;
            }
        }

        noCycleFromCurrentNode[startIndex] = true;
        existingNodes.remove(startIndex);
        return false;
    }
}
