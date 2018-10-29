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
        ]*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if ( nums == null || nums.length == 0) {
            return result;
        }

        ArrayList<Integer> existingNumbers = new ArrayList<>();

        permuteHelper(nums, 0, existingNumbers);

        return this.result;
    }

    private void permuteHelper(int[] nums, int currentIndex, ArrayList<Integer> existingNumbers) {

        if (currentIndex == nums.length - 1) {

            ArrayList<Integer> currentResult = new ArrayList<>(existingNumbers);
            currentResult.add(nums[currentIndex]);
            this.result.add(currentResult);

            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {

            int temp = nums[currentIndex];
            nums[currentIndex] = nums[i];
            nums[i] = temp;

            existingNumbers.add(nums[currentIndex]);

            permuteHelper(nums, currentIndex + 1, existingNumbers);

            existingNumbers.remove(existingNumbers.size() - 1);

            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;
        }
    }
}