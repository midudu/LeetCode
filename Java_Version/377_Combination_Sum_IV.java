/*
  Given an integer array with all positive numbers and no duplicates, find the
number of possible combinations that add up to a positive integer target.

Example:

        nums = [1, 2, 3]
        target = 4

        The possible combination ways are:
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)

  Note that different sequences are counted as different combinations.
Therefore the output is 7.

Follow up:
  What if negative numbers are allowed in the given array? How does it change
the problem? What limitation we need to add to the question to allow negative
numbers?
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Method 1: Bottom-Up
/*class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(new Solution().combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target <= 0) {
            return 0;
        }

        Arrays.sort(nums);

        int[] result = new int[target + 1];
        result[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                result[i] += result[i - num];
            }
        }

        return result[target];
    }
}*/


// Method 2: Top-Down with memory
class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(new Solution().combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target <= 0) {
            return 0;
        }

        Arrays.sort(nums);

        int[] ways = new int[target + 1];
        Arrays.fill(ways, Integer.MIN_VALUE);
        ways[0] = 1;

        return combinationSum4Helper(nums, ways, target);
    }

    private int combinationSum4Helper(int[] nums, int[] ways, int target) {

        if (ways[target] != Integer.MIN_VALUE) {
            return ways[target];
        }

        int result = 0;
        for (int num : nums) {
            if (num > target) {
                break;
            }
            result += combinationSum4Helper(nums, ways, target - num);
        }

        ways[target] = result;
        return result;
    }
}
