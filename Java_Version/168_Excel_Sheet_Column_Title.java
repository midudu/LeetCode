/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

        For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB*/


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

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        new Solution().isBalanced(root);
    }
}


class Solution {
    public String convertToTitle(int n) {

        if (n == 0) {
            return "";
        } else {
            n--;
            return convertToTitle(n / 26) + (char) ('A' + n % 26);
        }
    }
}