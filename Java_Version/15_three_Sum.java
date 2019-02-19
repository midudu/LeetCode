/*Given an array S of n integers, are there elements a, b, c in S such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of
zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }

        int numsLength = nums.length;
        int maxPositiveValue = nums[numsLength - 1] + nums[numsLength - 2];

        int startPointer = 0, endPointer = 0;

        for (int i = 0; i < numsLength - 2; i++) {

            if (nums[i] > 0 || nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] < -maxPositiveValue) {
                continue;
            }

            int target = 0 - nums[i];

            startPointer = i + 1;
            endPointer = numsLength - 1;

            while (startPointer < endPointer) {

                if (startPointer != i + 1
                        && nums[startPointer] == nums[startPointer - 1]) {
                    startPointer++;
                    continue;
                }

                if (endPointer != numsLength - 1
                        && nums[endPointer] == nums[endPointer + 1]) {
                    endPointer--;
                    continue;
                }

                int sum = nums[startPointer] + nums[endPointer];
                if (sum > target) {
                    endPointer--;
                } else if (sum < target) {
                    startPointer++;
                } else {

                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(nums[i]);
                    currentResult.add(nums[startPointer]);
                    currentResult.add(nums[endPointer]);

                    result.add(currentResult);
                    startPointer++;
                    endPointer--;
                }
            }
        }

        return result;
    }
}
