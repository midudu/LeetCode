/*
  You are given n pairs of numbers. In every pair, the first number is always
smaller than the second number.

  Now, we define a pair (c, d) can follow another pair (a, b) if and only if
b < c. Chain of pairs can be formed in this fashion.

  Given a set of pairs, find the length longest chain which can be formed.
You needn't use up all the given pairs. You can select pairs in any order.

Example 1:

        Input: [[1,2], [2,3], [3,4]]
        Output: 2
        Explanation: The longest chain is [1,2] -> [3,4]

Note:
  The number of given pairs will be in the range [1, 1000].
*/

import java.util.Arrays;

class Node implements Comparable<Node> {

    int start, end;

    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Node anotherNode) {

        if (this.end != anotherNode.end) {
            return Integer.compare(this.end, anotherNode.end);
        } else {
            return Integer.compare(anotherNode.start, this.start);
        }
    }
}

class Solution {

    public static void main(String[] args) {

        int[][] pairs = {{1,2}, {2,3}, {3,4}};

        System.out.println(new Solution().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {

        if (pairs == null || pairs.length == 0) {
            throw new RuntimeException("Illegal input");
        }

        Node[] nodes = new Node[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            nodes[i] = new Node(pairs[i][0], pairs[i][1]);
        }

        Arrays.sort(nodes);

        int result = 1;
        int last = nodes[0].end;

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].start > last) {
                result++;
                last = nodes[i].end;
            }
        }

        return result;
    }
}
