/*
  Given a sorted array nums, remove the duplicates in-place such that duplicates
appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the
input array in-place with O(1) extra memory.

Example 1:

        Given nums = [1,1,1,2,2,3],

        Your function should return length = 5, with the first five elements of
nums being 1, 1, 2, 2 and 3 respectively.

        It doesn't matter what you leave beyond the returned length.

Example 2:

        Given nums = [0,0,1,1,1,1,2,3,3],

        Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

        It doesn't matter what values are set beyond the returned length.
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lastValue = nums[0];
        int lastValueCount = 1;
        int newArrayPointer = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != lastValue) {

                nums[newArrayPointer] = nums[i];
                newArrayPointer++;
                lastValue = nums[i];
                lastValueCount = 1;

            } else {

                lastValueCount++;

                if (lastValueCount <= 2) {
                    nums[newArrayPointer] = nums[i];
                    newArrayPointer++;
                }
            }
        }

        return newArrayPointer;
    }
}