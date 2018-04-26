/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
        Example 1:
        Input: candies = [1,1,2,2,3,3]
        Output: 3
        Explanation:
        There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
        Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
        The sister has three different kinds of candies.
        Example 2:
        Input: candies = [1,1,2,3]
        Output: 2
        Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
        The sister has two different kinds of candies, the brother has only one kind of candies.
        Note:

        The length of the given array is in range [2, 10,000], and will be even.
        The number in given array is in range [-100,000, 100,000].*/


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
    public int distributeCandies(int[] candies) {

        int candiesLength = candies.length;
        int halfLength = candiesLength/2;

        HashSet<Integer> candiesType = new HashSet<>();

        int count = 0;
        for (int i = 0; i < candiesLength; i++) {
            if (candiesType.add(candies[i])){
                count++;
                if (count >= halfLength){
                    return halfLength;
                }
            }
        }

        return candiesType.size();
    }
}