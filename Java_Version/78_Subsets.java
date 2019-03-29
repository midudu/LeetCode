/*
Given a set of distinct integers, nums, return all possible subsets (the power
set).

Note: The solution set must not contain duplicate subsets.

Example:

        Input: nums = [1,2,3]
        Output:
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> currentSet = new ArrayList<>();

        subsetsHelper(nums, 0, currentSet, result);

        return result;
    }

    private void subsetsHelper(
            int[] nums, int currentIndex,
            ArrayList<Integer> existingSet,
            List<List<Integer>> result) {

        if (currentIndex == nums.length) {
            result.add(existingSet);
            return;
        }

        subsetsHelper(nums, currentIndex + 1, existingSet, result);

        ArrayList<Integer> existingSetCopy = new ArrayList<>(existingSet);
        existingSetCopy.add(nums[currentIndex]);
        subsetsHelper(nums, currentIndex + 1, existingSetCopy, result);
    }
}