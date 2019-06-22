/*
  Given a non-empty array of non-negative integers nums, the degree of this
array is defined as the maximum frequency of any one of its elements.

  Your task is to find the smallest possible length of a (contiguous) subarray
of nums, that has the same degree as nums.

Example 1:

        Input: [1, 2, 2, 3, 1]
        Output: 2

        Explanation:
          The input array has a degree of 2 because both elements 1 and 2 appear twice.
        Of the subarrays that have the same degree:
        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
        The shortest length is 2. So return 2.

Example 2:

        Input: [1,2,2,3,1,4,2]
        Output: 6

Note:

        nums.length will be between 1 and 50,000.
        nums[i] will be an integer between 0 and 49,999.
*/

import java.util.HashMap;
import java.util.HashSet;

class Node {

    int startIndex;
    int endIndex;
    int frequency;

    Node(int startIndex, int endIndex, int frequency) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.frequency = frequency;
    }
}

class Solution {

    public int findShortestSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], new Node(map.get(nums[i]).startIndex, i,
                        map.get(nums[i]).frequency + 1));
            } else {
                map.put(nums[i], new Node(i, i, 1));
            }
        }

        int length = Integer.MAX_VALUE;
        int frequency = Integer.MIN_VALUE;

        for (Node node : map.values()) {

            if (node.frequency > frequency) {
                length = node.endIndex - node.startIndex;
                frequency = node.frequency;
            } else if (node.frequency == frequency) {
                if (node.endIndex - node.startIndex < length) {
                    length = node.endIndex - node.startIndex;
                }
            }
        }

        return length + 1;
    }
}