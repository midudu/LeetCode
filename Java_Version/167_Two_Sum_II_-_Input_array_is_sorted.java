/*
  Given an array of integers that is already sorted in ascending order, find
two numbers such that they add up to a specific target number.

  The function twoSum should return indices of the two numbers such that they
add up to the target, where index1 must be less than index2. Please note that
your returned answers (both index1 and index2) are not zero-based.

  You may assume that each input would have exactly one solution and you may
not use the same element twice.

Example

        Input: numbers={2, 7, 11, 15}, target=9

        Output: index1=1, index2=2
*/

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int startPointer = 0, endPointer = numbers.length - 1;

        while (startPointer < endPointer) {

            int sum = numbers[startPointer] + numbers[endPointer];

            if (target == sum) {
                return new int[]{startPointer + 1, endPointer + 1};
            } else if (target < sum) {
                endPointer--;
            } else {
                startPointer++;
            }
        }

        throw new RuntimeException("illegal input");
    }
}
