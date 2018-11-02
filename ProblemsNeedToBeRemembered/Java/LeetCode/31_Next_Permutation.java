/*Implement next permutation,
which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible,
it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples.
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1*/


public class Solution {

    public void nextPermutation(int[] nums) {

        // Step 1: Check input parameters
        if (nums == null || nums.length == 0) {
            return;
        }

        // Step 2: Find the first index i which makes nums[i] < nums[i+1]
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // Step 3: If this array is in descending order, so there is no possible
        // arrangement, rearrange it as the lowest possible order.
        if (i < 0) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }

        // Step 4: Now we are sure that nums[i] < nums[i+1], so there must exist
        // one permutation which is greater if we rearrange nums[i] ~ nums[nums.length-1].
        // So we need to find nums[j] which is just larger than nums[i] exactly,
        // then a permutation which starts with nums[j] will be the next greater
        // permutation.
        int j;
        for (j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, i, j);

        // Step 5: Now the permutation starts with nums[j] and the subsequent
        // part in this array are in descending order. We need to find the next
        // greater permutation, so we should rearrange the subsequent part into
        // ascending order
        reverseArray(nums, i + 1, nums.length - 1);
    }

    private void reverseArray(int[] nums, int startIndex, int endIndex) {

        startIndex = (startIndex < 0 ? 0 : startIndex);
        endIndex = (endIndex >= nums.length ? nums.length - 1 : endIndex);

        while (startIndex < endIndex) {

            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}