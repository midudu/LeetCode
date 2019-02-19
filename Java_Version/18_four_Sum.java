/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

        Note: The solution set must not contain duplicate quadruplets.

        For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

        A solution set is:
        [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
        ]*/

import java.util.*;
import java.lang.Integer;


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        int numsLength = nums.length;
        int startPointer, endPointer;
        int sum;
        for (int i = 0; i < numsLength - 3; i++) {

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[nums.length - 1]
                    + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < numsLength - 2; j++) {

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (nums[i] + nums[j]
                        + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[numsLength - 1] + nums[numsLength - 2] < target) {
                    continue;
                }

                int newTarget = target - nums[i] - nums[j];

                startPointer = j + 1;
                endPointer = numsLength - 1;

                while (startPointer < endPointer) {

                    if (startPointer != j + 1) {
                        while (nums[startPointer] == nums[startPointer - 1]) {
                            startPointer++;
                        }
                    }

                    if (endPointer != numsLength - 1) {
                        while (nums[endPointer] == nums[endPointer + 1]) {
                            endPointer--;
                        }
                    }

                    if (startPointer >= endPointer) {
                        break;
                    }

                    sum = nums[startPointer] + nums[endPointer];
                    if (sum < newTarget) {
                        startPointer++;
                    } else if (sum > newTarget) {
                        endPointer--;
                    } else {

                        List<Integer> currentResult = new ArrayList<>();
                        currentResult.add(nums[i]);
                        currentResult.add(nums[j]);
                        currentResult.add(nums[startPointer]);
                        currentResult.add(nums[endPointer]);

                        result.add(currentResult);
                        startPointer++;
                        endPointer--;
                    }
                }
            }
        }

        return result;
    }
}
