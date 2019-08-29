/*
  Given an array nums containing n + 1 integers where each integer is between 1
and n (inclusive), prove that at least one duplicate number must exist. Assume
that there is only one duplicate number, find the duplicate one.

Example 1:

        Input: [1,3,4,2,2]
        Output: 2

Example 2:

        Input: [3,1,3,4,2]
        Output: 3

Note:
  1. You must not modify the array (assume the array is read only).
  2. You must use only constant, O(1) extra space.
  3. Your runtime complexity should be less than O(n^2).
  4. There is only one duplicate number in the array, but it could be repeated
  more than once.
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("illegal input");
        }

        return findDuplicateHelper(nums, 1, nums.length - 1);
    }

    private int findDuplicateHelper(int[] nums, int startNum, int endNum) {

        if (startNum == endNum) {
            return startNum;
        }

        int middleNum = startNum + (endNum - startNum) / 2;
        int count = 0;
        for (int num : nums) {
            if (num <= middleNum) {
                count++;
            }
        }

        return count > middleNum ? findDuplicateHelper(nums, startNum, middleNum) :
                findDuplicateHelper(nums, middleNum + 1, endNum);
    }
}
