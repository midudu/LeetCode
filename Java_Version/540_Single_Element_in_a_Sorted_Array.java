/*
  Given a sorted array consisting of only integers where every element appears
exactly twice except for one element which appears exactly once. Find this
single element that appears only once.

Example 1:

        Input: [1,1,2,3,3,4,4,8,8]
        Output: 2

Example 2:

        Input: [3,3,7,7,10,11,11]
        Output: 10

Note:
  Your solution should run in O(log n) time and O(1) space.
*/

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        System.out.println(new Solution().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {

        if (nums == null || (nums.length & 1) == 0) {
            throw new RuntimeException("illegal input");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return singleNonDuplicateHelper(nums, 0, nums.length - 1);
    }

    private int singleNonDuplicateHelper(int[] nums, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return nums[startIndex];
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (middleIndex == nums.length - 1) {
            return singleNonDuplicateHelper(nums, startIndex, endIndex);
        } else {
            int count = middleIndex - startIndex + 2;
            boolean oddCount = ((count & 1) != 0);
            if (nums[middleIndex] == nums[middleIndex + 1]) {
                return (oddCount ? singleNonDuplicateHelper(nums, startIndex, middleIndex - 1) :
                        singleNonDuplicateHelper(nums, middleIndex + 2, endIndex));
            } else {
                return (oddCount ? singleNonDuplicateHelper(nums, middleIndex + 1, endIndex) :
                        singleNonDuplicateHelper(nums, startIndex, middleIndex));
            }
        }
    }
}
