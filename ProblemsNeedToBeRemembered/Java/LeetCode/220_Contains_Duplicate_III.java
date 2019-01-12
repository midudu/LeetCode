/*
Given an array of integers,
find out whether there are two distinct indices i and j in the array
such that the absolute difference between nums[i] and nums[j] is at most t
and the absolute difference between i and j is at most k.

Example 1:

        Input: nums = [1,2,3,1], k = 3, t = 0
        Output: true

Example 2:

        Input: nums = [1,0,1,1], k = 1, t = 2
        Output: true

Example 3:

        Input: nums = [1,5,9,1,5,9], k = 2, t = 3
        Output: false
*/

import java.util.*;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Long> lastKNumbers = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long currentNumber = nums[i];

            Long maxNum = lastKNumbers.floor(currentNumber + t);
            if (maxNum != null && maxNum >= currentNumber) {
                return true;
            }

            Long minNum = lastKNumbers.ceiling(currentNumber - t);
            if (minNum != null && minNum <= currentNumber) {
                return true;
            }

            if (i >= k) {
                lastKNumbers.remove((long) nums[i - k]);
            }

            lastKNumbers.add((long) nums[i]);
        }

        return false;
    }
}