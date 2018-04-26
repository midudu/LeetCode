/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.*/


import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        ListNode result = new Solution().reverseList(root);

        //System.out.println(result);
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
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int numsLength = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();

        int length = Math.min(k+1,numsLength);
        for (int i = 0; i < length; i++ ){
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }

        for (int i = k + 1; i < numsLength; i++) {
            hashSet.remove(nums[i-k-1]);

            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }

        return false;
    }
}