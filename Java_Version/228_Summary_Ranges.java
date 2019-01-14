/*
Given a sorted integer array without duplicates, return the summary of its ranges.

        Example 1:

        Input:  [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
        Example 2:

        Input:  [0,2,3,4,6,8,9]
        Output: ["0","2->4","6","8->9"]
        Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int startIndex = nums[0];
        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1
                    || nums[i] + 1 != nums[i + 1]) {

                summaryRangesHelper(startIndex, nums[i], result);

                if (i != nums.length - 1) {
                    startIndex = nums[i + 1];
                }
            }
        }

        return result;
    }

    private void summaryRangesHelper(
            int startIndex, int endIndex, List<String> result) {

        if (startIndex == endIndex) {
            result.add(String.valueOf(startIndex));
        } else {
            String currentSummary = String.valueOf(startIndex)
                    + "->" + String.valueOf(endIndex);
            result.add(currentSummary);
        }
    }
}