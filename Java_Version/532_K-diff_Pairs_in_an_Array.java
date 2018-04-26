/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

        Example 1:
        Input: [3, 1, 4, 1, 5], k = 2
        Output: 2
        Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
        Although we have two 1s in the input, we should only return the number of unique pairs.
        Example 2:
        Input:[1, 2, 3, 4, 5], k = 1
        Output: 4
        Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
        Example 3:
        Input: [1, 3, 1, 5, 4], k = 0
        Output: 1
        Explanation: There is one 0-diff pair in the array, (1, 1).
        Note:
        The pairs (i, j) and (j, i) count as the same pair.
        The length of the array won't exceed 10,000.
        All the integers in the given input belong to the range: [-1e7, 1e7].*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        int[] ints = {3, 1, 4, 1, 5};
        new Solution().findPairs(ints, 2);

        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    private int result = 0;

    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length <= 1 || k < 0) {
            return 0;
        }

        int numsLength = nums.length;
        Arrays.sort(nums);

        if (k == 0) {
            processKEqualsZero(nums);
        } else {

            //k = Math.abs(k);
            processKMoreThanZero(nums, numsLength, k);
        }

        return result;
    }

    private void processKEqualsZero(int[] nums) {

        int lastValue = nums[0];
        int currentCount = 0;

        for (int num : nums) {
            if (num == lastValue) {
                currentCount++;
            } else {
                if (currentCount > 1) {
                    result++;
                }
                currentCount = 1;
                lastValue = num;
            }
        }

        if (currentCount > 1) {
            result++;
        }
    }

    private void processKMoreThanZero(int[] nums, int numsLength, int k) {

        int slowPointer = 0, fastPointer = 0;

        for (; slowPointer < numsLength && fastPointer < numsLength; slowPointer++) {

            if (slowPointer > 0 && nums[slowPointer] == nums[slowPointer - 1]) {
                continue;
            }

            fastPointer = Math.max(fastPointer, slowPointer);

            while (fastPointer < numsLength) {

                if (fastPointer > 0 && nums[fastPointer] == nums[fastPointer - 1]) {
                    fastPointer++;
                    continue;
                }

                if (nums[fastPointer] - nums[slowPointer] < k) {
                    fastPointer++;
                } else if (nums[fastPointer] - nums[slowPointer] == k) {
                    result++;
                    break;
                } else {
                    break;
                }
            }
        }
    }

}