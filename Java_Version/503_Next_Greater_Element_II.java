/*
  Given a circular array (the next element of the last element is the first
element of the array), print the Next Greater Number for every element. The
Next Greater Number of a number x is the first greater number to its
traversing-order next in the array, which means you could search circularly to
find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

        Input: [1,2,1]
        Output: [2,-1,2]

        Explanation: The first 1's next greater number is 2;
        The number 2 can't find next greater number;
        The second 1's next greater number needs to search circularly, which is
        also 2.

Note:
  The length of given array won't exceed 10000.
*/

import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 3};
        int[] result = new Solution().nextGreaterElements(nums);

        System.out.println(Arrays.toString(result));
    }

    private class Node {

        int val;
        int index;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] nextGreaterElements(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Node> stack = new Stack<>();

        for (int index = 0; index < nums.length; index++) {

            int currentNum = nums[index];
            while (!stack.isEmpty() && stack.peek().val < currentNum) {
                Node currentNode = stack.pop();
                result[currentNode.index] = currentNum;
            }
            stack.push(new Node(currentNum, index));
        }

        for (int num : nums) {

            if (stack.isEmpty()) {
                break;
            }
            while (!stack.isEmpty() && stack.peek().val < num) {
                Node currentNode = stack.pop();
                result[currentNode.index] = num;
            }
        }

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result[currentNode.index] = -1;
        }

        return result;
    }
}
