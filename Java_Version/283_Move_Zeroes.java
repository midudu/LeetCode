/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

        Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        StringBuilder a = new StringBuilder("ha");
        StringBuilder b = a;
        a.append("haha");

        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public void moveZeroes(int[] nums) {

        //method 1
        int numsLength = nums.length;
        int slowPointer = 0, fastPointer = 0;

        while (fastPointer < numsLength) {
            if (nums[fastPointer] != 0) {
                int temp = nums[slowPointer];
                nums[slowPointer] = nums[fastPointer];
                nums[fastPointer] = temp;
                slowPointer++;
            }

            fastPointer++;
        }

        //method 2
        /*for (int i = 0; i < numsLength; i++) {

            if (nums[i] != 0) {
                nums[i-zeroNumbers] = nums[i];
            } else {
                zeroNumbers++;
            }
        }

        for (int i = numsLength - zeroNumbers; i < numsLength; i++) {
            nums[i] = 0;
        }*/
    }
}