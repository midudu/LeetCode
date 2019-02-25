/*Given a sorted array and a target value, return the index if the target is
found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

        Example 1:

        Input: [1,3,5,6], 5
        Output: 2

        Example 2:

        Input: [1,3,5,6], 2
        Output: 1

        Example 3:

        Input: [1,3,5,6], 7
        Output: 4

        Example 1:

        Input: [1,3,5,6], 0
        Output: 0
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        } else if (nums[0] > target) {
            return 0;
        }

        int startIndex = 0, endIndex = nums.length - 1;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex;
            }
        }

        return startIndex;
    }
}