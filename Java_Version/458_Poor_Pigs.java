/*There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

        Answer this question, and write an algorithm for the follow-up general case.

        Follow-up:

        If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.*/


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

        int input = 1804289383;

        new Solution().arrangeCoins(input);
    }
}


class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int status = minutesToTest / minutesToDie + 1;
        int num_of_pig = 0;
        while (Math.pow(status, num_of_pig) < buckets) {
            num_of_pig++;
        }
        return num_of_pig;
    }
}