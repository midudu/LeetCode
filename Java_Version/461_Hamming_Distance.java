/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

        Given two integers x and y, calculate the Hamming distance.

        Note:
        0 ≤ x, y < 231.

        Example:

        Input: x = 1, y = 4

        Output: 2

        Explanation:
        1   (0 0 0 1)
        4   (0 1 0 0)
        ↑   ↑

        The above arrows point to positions where the corresponding bits are different.*/

import java.util.Arrays;
import java.lang.Math;
import java.lang.System;
import java.util.HashMap;
import java.lang.Integer;
import java.util.Iterator;
import java.util.Map;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 2};

        Solution solution = new Solution();
        int receive = solution.findShortestSubArray(nums);


        System.out.println("haha");
    }

}


class Solution {
    public int hammingDistance(int x, int y) {

        int result = x ^ y;

        return Integer.bitCount(result);
    }
}