/*
  Given a non-empty integer array, find the minimum number of moves required to 
make all array elements equal, where a move is incrementing a selected element 
by 1 or decrementing a selected element by 1.

  You may assume the array's length is at most 10,000.

Example:

    Input:
    [1,2,3]

    Output:
    2

    Explanation:
      Only two moves are needed (remember each move increments or decrements 
    one element): [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/


import java.util.Arrays;

class Solution {

    public int minMoves2(int[] nums) {
        
        if ( nums == null || nums.length <= 1 ) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;

        int startIndex = 0, endIndex = nums.length - 1;
        while (startIndex < endIndex ) {
            result += (nums[endIndex] - nums[startIndex]);
            startIndex++;
            endIndex--;
        }

        return result;
    }
}
