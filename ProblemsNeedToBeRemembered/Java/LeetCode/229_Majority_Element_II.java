/*
Given an integer array of size n,
find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

        Example 1:

        Input: [3,2,3]
        Output: [3]

        Example 2:

        Input: [1,1,1,3,3,2,2,2]
        Output: [1,2]
*/

import java.util.ArrayList;
import java.util.List;

// see "https://www.cnblogs.com/franknihao/p/9396491.html"
// Boyer-Moore algorithm
class Solution {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int majorityOne = nums[0];
        int majorityTwo = nums[1];

        int oneCount = 0;
        int twoCount = 0;

        // Step 1: select
        for (int vote : nums) {

            if (vote == majorityOne) {
                oneCount++;
            } else if (vote == majorityTwo) {
                twoCount++;
            } else if (oneCount == 0) {
                majorityOne = vote;
                oneCount = 1;
            } else if (twoCount == 0) {
                majorityTwo = vote;
                twoCount = 1;
            } else {

                oneCount--;
                twoCount--;
            }
        }

        // Step 2: check legality
        int threshold = nums.length / 3;
        oneCount = 0;
        twoCount = 0;

        for (int vote : nums) {

            if (vote == majorityOne) {
                oneCount++;
            } else if (vote == majorityTwo) {
                twoCount++;
            }
        }

        if (oneCount > threshold) {
            result.add(majorityOne);
        }
        if (twoCount > threshold) {
            result.add(majorityTwo);
        }

        return result;
    }
}