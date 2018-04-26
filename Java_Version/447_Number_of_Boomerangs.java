/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

        Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

        Example:
        Input:
        [[0,0],[1,0],[2,0]]

        Output:
        2

        Explanation:
        The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        new Solution().countSegments("   f");

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
    public int numberOfBoomerangs(int[][] points) {

        int pointNumbers = points.length;
        int result = 0;

        for (int i = 0; i < pointNumbers; i++) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < pointNumbers; j++) {

                if (i == j) {
                    continue;
                }


                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                hashMap.put(distance, hashMap.getOrDefault(distance, 0) + 1);
            }

            for (Integer count : hashMap.values()) {
                result += count * (count - 1);
            }
        }

        return result;
    }
}