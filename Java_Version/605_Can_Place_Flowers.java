/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

        Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

        Example 1:
        Input: flowerbed = [1,0,0,0,1], n = 1
        Output: True
        Example 2:
        Input: flowerbed = [1,0,0,0,1], n = 2
        Output: False
        Note:
        The input array won't violate no-adjacent-flowers rule.
        The input array size is in the range of [1, 20000].
        n is a non-negative integer which won't exceed the input array size.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);

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
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 0) {
            return false;
        } else if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }

        int length = flowerbed.length;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            if (n == 0) {
                return true;
            }
            flowerbed[0] = 1;
        }
        for (int i = 1; i < length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        if (flowerbed[length - 1] == 0 && flowerbed[length - 2] == 0) {
            n--;
        }
        return n == 0;
    }
}