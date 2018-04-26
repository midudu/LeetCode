/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

        Example:

        Input:
        [1,2,3]

        Output:
        3

        Explanation:
        Only three moves are needed (remember each move increments two elements):

        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        int input = 1804289383;

        new Solution().arrangeCoins(input);
    }
}


class Solution {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (nums[i] - min);
        }

        return result;
    }
}