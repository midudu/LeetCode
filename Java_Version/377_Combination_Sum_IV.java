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

        1: 1
        2: 1 + 1 = 2
        3: 1 +


  Note that different sequences are counted as different combinations.

  Therefore the output is 7.

  Follow up:
        What if negative numbers are allowed in the given array?
        How does it change the problem?
        What limitation we need to add to the question to allow negative numbers?
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// Method 1: DFS
/*class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};

        int result = new Solution().combinationSum4(nums, 4);

        System.out.println(result);
    }


    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        return combinationSum4Helper(nums, target, map);
    }

    private int combinationSum4Helper(int[] nums, int target, Map<Integer, Integer> map) {

        if (map.containsKey(target)) {
            return map.get(target);
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < target) {
                result += combinationSum4Helper(nums, target - nums[i], map);
            } else if (nums[i] == target) {
                result++;
                break;
            }
        }

        map.put(target, result);

        return result;
    }
}*/

// Method 2: DP
class Solution {

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int[] result = new int[target + 1];
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {

            for (int num : nums) {

                if (num > i) {
                    break;
                }

                result[i] += result[i - num];
            }
        }

        return result[target];
    }
}
