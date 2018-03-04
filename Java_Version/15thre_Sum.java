/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note: The solution set must not contain duplicate triplets.

        For example, given array S = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Main {
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        Solution solution = new Solution();

        List<List<Integer>> receive = solution.threeSum(nums);


        System.out.println("haha");

    }


}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> returnValue = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return returnValue;
        }

        Arrays.sort(nums);
        int numsLength = nums.length;
        int maxPositiveValue = nums[numsLength - 1] + nums[numsLength - 2];
        int startPointer = 0, endPointer = 0;
        int sum = 0;
        for (int i = 0; i < numsLength; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] < -maxPositiveValue) {
                continue;
            }

            startPointer = i + 1;
            endPointer = numsLength - 1;

            while (startPointer < endPointer) {
                if (startPointer != i + 1 && nums[startPointer] == nums[startPointer - 1]) {
                    startPointer++;
                    continue;
                }
                if (endPointer != numsLength - 1 && nums[endPointer] == nums[endPointer + 1]) {
                    endPointer--;
                    continue;
                }

                sum = nums[i] + nums[startPointer] + nums[endPointer];
                if (sum > 0) {
                    endPointer--;
                } else if (sum < 0) {
                    startPointer++;
                } else {
                    returnValue.add(Arrays.asList(nums[i],nums[startPointer],nums[endPointer]));
                    startPointer++;
                    endPointer--;
                }
            }
        }

        return returnValue;
    }
}