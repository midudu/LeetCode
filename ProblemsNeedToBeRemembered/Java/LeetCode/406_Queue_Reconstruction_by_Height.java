/*
  Suppose you have a random list of people standing in a queue. Each person is
described by a pair of integers (h, k), where h is the height of the person and
k is the number of people in front of this person who have a height greater
than or equal to h. Write an algorithm to reconstruct the queue.

Note:
  The number of people is less than 1,100.

Example
        Input:
        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

        Output:
        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

import java.util.Arrays;

class Solution {

    private class Node implements Comparable<Node> {

        int h, k;

        Node(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public int compareTo(Node o) {

            if (this.h != o.h) {
                return Integer.compare(this.h, o.h);
            }
            return Integer.compare(o.k, this.k);
        }
    }

    public static void main(String[] args) {

        int[][] people = {{0, 0}, {6, 2}, {5, 5}, {4, 3}, {5, 2},
                {1, 1}, {6, 0}, {6, 3}, {7, 0}, {5, 1}};

        int[][] result = new Solution().reconstructQueue(people);
        System.out.println();
    }

    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0) {
            return new int[0][2];
        }

        int[][] result = new int[people.length][2];
        boolean[] hasNode = new boolean[result.length];

        Node[] nodes = new Node[people.length];
        for (int i = 0; i < people.length; i++) {
            nodes[i] = new Node(people[i][0], people[i][1]);
        }
        Arrays.sort(nodes);

        for (Node node : nodes) {

            int count = 0;
            for (int i = 0; i < result.length; i++) {

                if (!hasNode[i]) {
                    count++;
                    if (count > node.k) {
                        result[i][0] = node.h;
                        result[i][1] = node.k;
                        hasNode[i] = true;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
