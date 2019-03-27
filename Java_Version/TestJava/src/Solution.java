/*
Given a collection of numbers that might contain duplicates, return all possible
unique permutations.

        Example:

        Input: [1,1,2]
        Output:
        [
        [1,1,2],
        [1,2,1],
        [2,1,1]
        ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        if ( nums == null || nums.length == 0 ) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        boolean[] hasUsed = new boolean[nums.length];

        List<Integer> currentResult = new ArrayList<>();

        permuteUniqueHelper(nums, hasUsed, currentResult, result);

        return result;
    }

    private void permuteUniqueHelper(
            int[] nums, boolean[] hasUsed,
            List<Integer> currentResult, List<List<Integer>> result) {

        if ( currentResult.size() == nums.length ) {

            List<Integer> currentResultCopy = new ArrayList<Integer>(currentResult);
            result.add(currentResultCopy);
            return;
        }

        Integer lastNumber = null;

        for (int i = 0; i < nums.length; i++) {

            if (hasUsed[i] == true || (lastNumber != null && lastNumber == nums[i])) {
                continue;
            }

            hasUsed[i] = true;
            lastNumber = nums[i];
            currentResult.add(nums[i]);

            permuteUniqueHelper(nums, hasUsed, currentResult, result);

            hasUsed[i] = false;
            currentResult.remove(currentResult.size() - 1);
        }
    }
}