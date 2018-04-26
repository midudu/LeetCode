/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

        Example:
        Given nums = [-2, 0, 3, -5, 2, -1]

        sumRange(0, 2) -> 1
        sumRange(2, 5) -> -1
        sumRange(0, 5) -> -3
        Note:
        You may assume that the array does not change.
        There are many calls to sumRange function.*/


import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        String s = "egg", t = "add";

        new Solution().isIsomorphic(s, t);
    }
}


class NumArray {

    private int[] numsSumStorage;

    public NumArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        numsSumStorage = new int[nums.length];
        numsSumStorage[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            numsSumStorage[i] = nums[i] + numsSumStorage[i - 1];
        }
    }

    public int sumRange(int i, int j) {

        if (numsSumStorage == null || numsSumStorage.length == 0) {
            return 0;
        }

        i = Math.max(0, i);
        j = Math.min(numsSumStorage.length - 1, j);

        if (i == 0) {
            return numsSumStorage[j];
        } else {
            return numsSumStorage[j] - numsSumStorage[i - 1];
        }

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */