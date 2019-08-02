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

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums).toString());
    }

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
            int[] nums, int startIndex, List<Integer> existingNumbers,
            List<List<Integer>> result) {

        if (startIndex == nums.length) {
            result.add(new ArrayList<>(existingNumbers));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            if (i != startIndex) {
                swap(nums, i, startIndex);
            }
            existingNumbers.add(nums[startIndex]);
            permuteHelper(nums, startIndex + 1, existingNumbers, result);
            existingNumbers.remove(existingNumbers.size() - 1);
            if (i != startIndex) {
                swap(nums, i, startIndex);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}