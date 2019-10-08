/*
  Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

        Input: [1,1,0,1,1,1]
        Output: 3
        
        Explanation: The first two digits or the last three digits are 
        consecutive 1s. The maximum number of consecutive 1s is 3.
        
Note:
  1. The input array will only contain 0 and 1.
  2. The length of input array is a positive integer and will not exceed 10,000
*/

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,1,0,1,1,1};

        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
    
        int currentIndex = 0;
        while (currentIndex < nums.length) {

            while (currentIndex < nums.length && nums[currentIndex] != 1) {
                currentIndex++;
            }
            int startIndex = currentIndex;

            while (currentIndex < nums.length && nums[currentIndex] == 1) {
                currentIndex++;
            }
            result = Math.max(result, currentIndex - startIndex);
        }

        return result;
    }
}
