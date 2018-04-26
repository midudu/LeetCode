/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

        Note: You may not slant the container and n is at least 2.*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Main {
    public static void main(String[] args) {
        int x = 1;

        Solution solution = new Solution();

        boolean receive = solution.isPalindrome(x);


        System.out.println("haha");

    }


}


class Solution {
    public int maxArea(int[] height) {

        int startPointer = 0, endPointer = height.length - 1;
        int maxAreaValue = 0;
        int startPointerHeight = 0, endPointerHeight = 0;

        while (startPointer < endPointer) {

            startPointerHeight = height[startPointer];
            endPointerHeight = height[endPointer];

            maxAreaValue = Math.max(maxAreaValue,
                    (endPointer - startPointer) * Math.min(startPointerHeight, endPointerHeight));

            if ( startPointerHeight <= endPointerHeight ){
                startPointer++;
            }else{
                endPointer--;
            }
        }

        return maxAreaValue;
    }
}