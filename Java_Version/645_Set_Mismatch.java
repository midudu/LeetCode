/*
  The set S originally contains numbers from 1 to n. But unfortunately, due to
the data error, one of the numbers in the set got duplicated to another number
in the set, which results in repetition of one number and loss of another number.

  Given an array nums representing the data status of this set after the error.
Your task is to firstly find the number occurs twice and then find the number
that is missing. Return them in the form of an array.

Example 1:

        Input: nums = [1,2,2,4]
        Output: [2,3]

Note:
  The given array size will in the range [2, 10000].

  The given array's numbers won't have any order.
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 1, 2};

        int[] result = new Solution().findErrorNums(nums);

        System.out.println(Arrays.toString(result));
    }

    public int[] findErrorNums(int[] nums) {

        if (nums == null || nums.length < 2) {
            throw new RuntimeException("Illegal input");
        }

        int[] result = new int[2];

        boolean[] map = new boolean[nums.length + 1];

        for (int num : nums) {

            if (map[num]) {
                result[0] = num;
            }
            map[num] = true;
        }

        for (int i = 1; i < map.length; i++) {
            if (!map[i]) {
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
