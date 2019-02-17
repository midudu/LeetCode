/*Given an array of integers, return indices of the two numbers such that they
add up to a specific target.

You may assume that each input would have exactly one solution, and you may not
use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> leftNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (leftNumbers.containsKey(nums[i])) {
                return new int[]{leftNumbers.get(nums[i]), i};
            } else {
                leftNumbers.put(target - nums[i], i);
            }
        }

        return null;
    }
}