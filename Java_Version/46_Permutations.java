/*
Given a collection of distinct integers, return all possible permutations.

        Example:

        Input: [1,2,3]
        Output:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> existingNumbers = new ArrayList<>();

        permuteHelper(nums, 0, existingNumbers, result);

        return result;
    }

    private void permuteHelper(
            int[] nums, int currentIndex,
            List<Integer> existingNumbers, List<List<Integer>> result) {

        if (currentIndex == nums.length) {

            result.add(new ArrayList<>(existingNumbers));
            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {

            int temp = nums[currentIndex];
            nums[currentIndex] = nums[i];
            nums[i] = temp;

            existingNumbers.add(nums[currentIndex]);
            permuteHelper(nums, currentIndex + 1,
                    existingNumbers, result);
            existingNumbers.remove(existingNumbers.size() - 1);

            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;
        }
    }
}