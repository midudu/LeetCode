/*
  Find the kth largest element in an unsorted array.

  Note that it is the kth largest element in the sorted order, not the kth
distinct element.

Example 1:

  Input: [3,2,1,5,6,4] and k = 2
  Output: 5

Example 2:

  Input: [3,2,3,1,2,4,5,5,6] and k = 4
  Output: 4

Note:
  You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {

    public int findKthLargest(int[] nums, int k) {

        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargestHelper(
            int[] nums, int startIndex, int endIndex, int k) {

        int standardElement = nums[startIndex];

        int pointer1 = startIndex, pointer2 = endIndex;

        while (pointer1 < pointer2) {

            while (pointer1 < pointer2 && nums[pointer2] >= standardElement) {
                pointer2--;
            }

            if (pointer1 < pointer2) {
                nums[pointer1] = nums[pointer2];
                pointer1++;
            }

            while (pointer1 < pointer2 && nums[pointer1] <= standardElement) {
                pointer1++;
            }

            if (pointer1 < pointer2) {
                nums[pointer2] = nums[pointer1];
                pointer2--;;
            }
        }

        if (pointer1 == k) {
            return standardElement;
        } else if (pointer1 < k) {
            return findKthLargestHelper(nums, pointer1 + 1, endIndex, k);
        } else {
            return findKthLargestHelper(nums, startIndex, pointer1 - 1, k);
        }
    }
}
