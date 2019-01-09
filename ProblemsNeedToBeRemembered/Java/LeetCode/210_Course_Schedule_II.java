/*

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites,
for example to take course 0 you have to first take course 1, w
hich is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.

        Example 1:

        Input: 2, [[1,0]]
        Output: [0,1]
        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
        course 0. So the correct course order is [0,1] .

        Example 2:

        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,1,2,3] or [0,2,1,3]

        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
        courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:

The input prerequisites is a graph represented by a list of edges,
not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.*/


import java.util.*;

// Method 1: Topology
/*
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        HashMap<Integer, ArrayList<Integer>> prerequisitesMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];

            ArrayList<Integer> postSet = prerequisitesMap.getOrDefault(pre,
                    new ArrayList<>());
            postSet.add(post);
            prerequisitesMap.put(pre, postSet);

            inDegree[post]++;
        }

        int[] result = new int[numCourses];
        int currentIndex = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {

            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            result[currentIndex] = currentNode;
            currentIndex++;

            if (prerequisitesMap.containsKey(currentNode)) {

                ArrayList<Integer> currentNodePostList
                        = prerequisitesMap.get(currentNode);

                for (int currentNodePostNode: currentNodePostList) {

                    inDegree[currentNodePostNode]--;

                    if (inDegree[currentNodePostNode] == 0) {
                        queue.offer(currentNodePostNode);
                    }
                }
            }
        }

        if (currentIndex == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}*/


// Method 2: DFS
class Solution {

    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;

    private boolean isPossible;
    private Map<Integer, Integer> color;
    private Map<Integer, List<Integer>> adjList;
    private List<Integer> topologicalOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.init(numCourses);

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {

            if (this.color.get(i) == WHITE) {
                this.dfs(i);
            }
        }

        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    private void init(int numCourses) {

        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {

        // Don't recurse further if we found a cycle already
        if (!this.isPossible) {
            return;
        }

        // Start the recursion
        this.color.put(node, GRAY);

        // Traverse on neighboring vertices
        for (Integer neighbor :
                this.adjList.getOrDefault(node, new ArrayList<Integer>())) {

            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }


}