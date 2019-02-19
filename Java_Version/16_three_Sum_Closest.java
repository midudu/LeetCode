/*Given an array nums of n integers and an integer target, find three integers
in nums such that the sum is closest to target. Return the sum of the three
integers.

You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

import java.util.Arrays;
import java.lang.Math;

class Solution {

    public static void main(String[] args) {


    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int numsLength = nums.length;

        int minValue = nums[0] + nums[1] + nums[2];
        if (minValue >= target) {
            return minValue;
        }

        int maxValue = nums[numsLength - 1]
                + nums[numsLength - 2] + nums[numsLength - 3];
        if (maxValue <= target) {
            return maxValue;
        }

        int startPointer = 0, endPointer = 0;
        int result = minValue;

        for (int i = 0; i < numsLength - 2; i++) {

            int minCurrentResult = nums[i] + nums[i + 1] + nums[i + 2];

            if (minCurrentResult >= target) {

                result = Math.abs(minCurrentResult - target)
                        < Math.abs(result - target) ? minCurrentResult : result;
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int currentTarget = target - nums[i];

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

                int currentValue = nums[startPointer] + nums[endPointer];
                if (currentValue > currentTarget) {
                    endPointer--;
                } else if (currentValue < currentTarget) {
                    startPointer++;
                } else {
                    return target;
                }
                
                result = Math.abs(currentValue + nums[i] - target)
                        < Math.abs(result - target) ?
                        currentValue + nums[i] : result;

            }
        }

        return result;
    }
}