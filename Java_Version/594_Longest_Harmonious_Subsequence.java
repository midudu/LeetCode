/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

        Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

        Example 1:
        Input: [1,3,2,2,5,2,3,7]
        Output: 5
        Explanation: The longest harmonious subsequence is [3,2,2,2,3].
        Note: The length of the input array will not exceed 20,000.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);

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
    public int findLHS(int[] nums) {

        int numsLength = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numsLength; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        int result = 0;
        int temp;
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();

            result = Math.max(result, (Integer) pair.getValue() + hashMap.getOrDefault((Integer) pair.getKey() + 1, -(Integer) pair.getValue()));
            result = Math.max(result, (Integer) pair.getValue() + hashMap.getOrDefault((Integer) pair.getKey() - 1, -(Integer) pair.getValue()));
        }

        return result;
    }
}