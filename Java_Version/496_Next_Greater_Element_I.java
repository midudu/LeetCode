/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

        The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

        Example 1:
        Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
        Output: [-1,3,-1]
        Explanation:
        For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
        For number 1 in the first array, the next greater number for it in the second array is 3.
        For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
        Example 2:
        Input: nums1 = [2,4], nums2 = [1,2,3,4].
        Output: [3,-1]
        Explanation:
        For number 2 in the first array, the next greater number for it in the second array is 3.
        For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
        Note:
        All elements in nums1 and nums2 are unique.
        The length of both nums1 and nums2 would not exceed 1000.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        int a = 3, b = 0;


        int result = a / b;


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
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length, nums2Length = nums2.length;

        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums2Length; i++) {

            int currentNum = nums2[i];

            while (!stack.empty() && stack.peek() < currentNum) {
                hashMap.put(stack.pop(), currentNum);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1Length; i++) {
            nums1[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}