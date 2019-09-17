/*
  Given a non-empty array of integers, return the k most frequent elements.

Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

Example 2:

        Input: nums = [1], k = 1
        Output: [1]

Note:
  1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  2. Your algorithm's time complexity must be better than O(n log n), where n
  is the array's size.
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1};
        int k = 1;

        List<Integer> result = new Solution().topKFrequent(nums, k);
        System.out.println(result.toString());
    }

    private class Node implements Comparable<Node> {

        int num, count;

        Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> count = new HashMap<>(nums.length);
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Node[] nodes = new Node[count.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            nodes[i] = new Node(entry.getKey(), entry.getValue());
            i++;
        }

        Arrays.sort(nodes);

        for (i = nodes.length - 1; i >= nodes.length - k; i--) {
            result.add(nodes[i].num);
        }

        return result;
    }
}
