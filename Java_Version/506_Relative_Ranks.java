/*Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

        Example 1:
        Input: [5, 4, 3, 2, 1]
        Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
        Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
        For the left two athletes, you just need to output their relative ranks according to their scores.
        Note:
        N is a positive integer and won't exceed 10,000.
        All the scores of athletes are guaranteed to be unique.*/


import java.util.*;

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

        new Solution().findRelativeRanks(new int[]{2, 4, 5, 1, 0});
    }
}


class Solution {
    public String[] findRelativeRanks(int[] nums) {

        int[] numsCopy = nums.clone();
        Arrays.sort(nums);

        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            rank.put(nums[i], nums.length - i);
        }

        String[] result = new String[nums.length];
        for (int i = 0; i < numsCopy.length; i++) {
            int index = rank.get(numsCopy[i]);
            switch (index) {
                case 1: {
                    result[i] = "Gold Medal";
                    break;
                }
                case 2: {
                    result[i] = "Silver Medal";
                    break;
                }
                case 3: {
                    result[i] = "Bronze Medal";
                    break;
                }
                default: {
                    result[i] = Integer.toString(index);
                }
            }
        }

        return result;
    }
}