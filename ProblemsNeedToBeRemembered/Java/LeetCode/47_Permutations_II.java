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

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> existingNumbers = new ArrayList<>();

        permuteUniqueHelper(nums, used, existingNumbers, result);

        return result;
    }

    private void permuteUniqueHelper(
            int[] nums, boolean[] used,
            List<Integer> existingNumbers, List<List<Integer>> result) {

        if (existingNumbers.size() == nums.length) {

            result.add(new ArrayList<>(existingNumbers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            existingNumbers.add(nums[i]);

            permuteUniqueHelper(nums, used, existingNumbers, result);

            existingNumbers.remove(existingNumbers.size() - 1);
            used[i] = false;
        }
    }
}