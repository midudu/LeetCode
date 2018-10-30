/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        Example:

        Input: [1,1,2]
        Output:
        [
        [1,1,2],
        [1,2,1],
        [2,1,1]
        ]*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {


        if ( nums == null || nums.length == 0) {
            return result;
        }

        ArrayList<Integer> existingNumbers = new ArrayList<>();

        permuteUniqueHelper(nums, 0, existingNumbers);

        return this.result;
    }

    private void permuteUniqueHelper(
            int[] nums, int currentIndex, ArrayList<Integer> existingNumbers) {

        if (currentIndex == nums.length - 1) {

            ArrayList<Integer> currentResult = new ArrayList<>(existingNumbers);
            currentResult.add(nums[currentIndex]);
            this.result.add(currentResult);

            return;
        }

        HashSet<Integer> headNumbers = new HashSet<>();

        for (int i = currentIndex; i < nums.length; i++) {

            if (headNumbers.contains(nums[i])) {
                continue;
            }

            headNumbers.add(nums[i]);

            int temp = nums[currentIndex];
            nums[currentIndex] = nums[i];
            nums[i] = temp;

            existingNumbers.add(nums[currentIndex]);

            permuteUniqueHelper(nums, currentIndex + 1, existingNumbers);

            existingNumbers.remove(existingNumbers.size() - 1);

            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;
        }
    }
}