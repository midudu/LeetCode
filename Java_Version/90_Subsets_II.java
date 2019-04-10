/*
  Given a collection of integers that might contain duplicates, nums, return
all possible subsets (the power set).

Note:
  The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> existingNumbers = new ArrayList<>();

        subsetsWithDupHelper(nums, 0, existingNumbers, result);

        return result;
    }

    private int findNextDifferentNumberIndex(int[] nums, int currentIndex) {

        for (int i = currentIndex + 1; i < nums.length; i++) {

            if (nums[i] != nums[currentIndex]) {
                return i;
            }
        }

        return nums.length;
    }

    private void subsetsWithDupHelper(
            int[] nums, int currentIndex,
            List<Integer> existingNumbers, List<List<Integer>> result) {

        if (currentIndex == nums.length) {
            result.add(existingNumbers);
            return;
        }

        List<Integer> existingNumbersCopy = new ArrayList<>(existingNumbers);
        existingNumbersCopy.add(nums[currentIndex]);
        subsetsWithDupHelper(nums, currentIndex + 1,
                existingNumbersCopy, result);

        int nextIndex = findNextDifferentNumberIndex(nums, currentIndex);
        subsetsWithDupHelper(nums, nextIndex, existingNumbers, result);
    }
}
