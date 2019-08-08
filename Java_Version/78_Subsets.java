/*
  Given a set of distinct integers, nums, return all possible subsets (the power
set).

Note:
  The solution set must not contain duplicate subsets.

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

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Solution().subsets(nums);

        System.out.println();
    }

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentSet = new ArrayList<>();

        subsetsHelper(nums, 0, currentSet, result);

        return result;
    }

    private void subsetsHelper(
            int[] nums, int startIndex,
            List<Integer> existingSet,
            List<List<Integer>> result) {

        if (startIndex == nums.length) {
            result.add(existingSet);
            return;
        }

        subsetsHelper(nums, startIndex + 1, existingSet, result);

        List<Integer> existingSetCopy = new ArrayList<>(existingSet);
        existingSetCopy.add(nums[startIndex]);
        subsetsHelper(nums, startIndex + 1, existingSetCopy, result);
    }
}