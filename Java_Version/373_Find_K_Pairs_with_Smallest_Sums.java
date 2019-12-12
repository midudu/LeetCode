/*
  You are given two integer arrays nums1 and nums2 sorted in ascending order
and an integer k.

  Define a pair (u,v) which consists of one element from the first array and
one element from the second array.

  Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

        Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        Output: [[1,2],[1,4],[1,6]]
        Explanation: The first 3 pairs are returned from the sequence:
        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

        Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        Output: [1,1],[1,1]
        Explanation: The first 2 pairs are returned from the sequence:
        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

        Input: nums1 = [1,2], nums2 = [3], k = 3
        Output: [1,3],[2,3]
        Explanation: All possible pairs are returned from the sequence:
        [1,3],[2,3]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        int k = 3;

        System.out.println(new Solution().kSmallestPairs(nums1, nums2, k));
    }

    private class Pair {

        int index1, index2;
        int sum;

        Pair(int index1, int index2, int[] nums1, int[] nums2) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = nums1[index1] + nums2[index2];
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if (k < 0) {
            throw new RuntimeException("illegal input");
        }
        List<List<Integer>> result = new ArrayList<>(k);
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0
                || k == 0) {
            return result;
        }

        int[] startPosition = new int[nums1.length];

        while (result.size() < Math.min(k, nums1.length * nums2.length)) {
            Pair pair = null;
            for (int i = 0; i < nums1.length; i++) {

                if (startPosition[i] == nums2.length) {
                    continue;
                }

                if (pair == null) {
                    pair = new Pair(i, startPosition[i], nums1, nums2);
                } else {
                    int currentSum = nums1[i] + nums2[startPosition[i]];
                    if (currentSum < pair.sum) {
                        pair = new Pair(i, startPosition[i], nums1, nums2);
                    }
                }

                if (startPosition[i] == 0) {
                    break;
                }
            }

            List<Integer> currentResult = new ArrayList<>(2);
            currentResult.add(nums1[pair.index1]);
            currentResult.add(nums2[pair.index2]);
            result.add(currentResult);
            startPosition[pair.index1]++;
        }

        return result;
    }
}
