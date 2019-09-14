/*
  There are a total of n courses you have to take, labeled from 0 to n-1. Some
courses may have prerequisites, for example to take course 0 you have to first
take course 1, which is expressed as a pair: [0,1]
  Given the total number of courses and a list of prerequisite pairs, return
the ordering of courses you should take to finish all courses. There may be
multiple correct orders, you just need to return one of them. If it is
impossible to finish all courses, return an empty array.

Example 1:

        Input: 2, [[1,0]]
        Output: [0,1]

        Explanation: There are a total of 2 courses to take. To take course 1
        you should have finished course 0. So the correct course order is [0,1].

Example 2:

        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,1,2,3] or [0,2,1,3]

        Explanation: There are a total of 4 courses to take. To take course 3
        you should have finished both courses 1 and 2. Both courses 1 and 2
        should be taken after you finished course 0. So one correct course
        order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:
  1. The input prerequisites is a graph represented by a list of edges, not
  adjacency matrices. Read more about how a graph is represented.
  2. You may assume that there are no duplicate edges in the input prerequisites.
*/


import java.util.*;

class Solution {

    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(
                new Solution().findOrder(numCourses, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 1. Initial Check
        if (numCourses < 0) {
            throw new RuntimeException("illegal input");
        }
        if (numCourses == 0) {
            return new int[0];
        }
        if (prerequisites == null || prerequisites.length == 0) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        // 2. Initial map and count table
        int[] preCoursesCount = new int[numCourses];
        Map<Integer, List<Integer>> postCoursesMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int currentCourse = prerequisite[0];
            int preCourse = prerequisite[1];

            preCoursesCount[currentCourse]++;
            List<Integer> postCourses;
            if (postCoursesMap.containsKey(preCourse)) {
                postCourses = postCoursesMap.get(preCourse);
            } else {
                postCourses = new ArrayList<>();
            }
            postCourses.add(currentCourse);
            postCoursesMap.put(preCourse, postCourses);
        }

        // 3
        int[] result = new int[numCourses];
        int resultIndex = 0;
        Queue<Integer> noPreCourses = new LinkedList<>();
        for (int i = 0; i < preCoursesCount.length; i++) {
            if (preCoursesCount[i] == 0) {
                noPreCourses.offer(i);
            }
        }

        while (!noPreCourses.isEmpty()) {
            int currentCourse = noPreCourses.poll();

            result[resultIndex] = currentCourse;
            resultIndex++;

            if (postCoursesMap.containsKey(currentCourse)) {
                List<Integer> postCourses = postCoursesMap.get(currentCourse);
                for (int postCourse : postCourses) {
                    preCoursesCount[postCourse]--;
                    if (preCoursesCount[postCourse] == 0) {
                        noPreCourses.offer(postCourse);
                    }
                }
            }
        }

        return (resultIndex == numCourses ? result : new int[0]);
    }
}
