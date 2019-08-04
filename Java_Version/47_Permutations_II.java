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

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        permuteUniqueHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private void permuteUniqueHelper(
            List<List<Integer>> result, List<Integer> existingNums, int[] nums, boolean[] used) {

        if (existingNums.size() == nums.length) {
            result.add(new ArrayList<>(existingNums));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] ||
                    i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            existingNums.add(nums[i]);

            permuteUniqueHelper(result, existingNums, nums, used);

            used[i] = false;
            existingNums.remove(existingNums.size() - 1);
        }
    }
}
