/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a column title as appear in an Excel sheet, return its corresponding column number.

        For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28*/


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
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        new Solution().levelOrderBottom(root);
    }
}


class Solution {
    public int titleToNumber(String s) {

        int result = 0;
        int sLength = s.length();
        int scale = 1;
        for (int i = sLength - 1; i >= 0; i--) {

            result += scale * (s.charAt(i) - 'A' + 1);
            scale *= 26;
        }

        return result;
    }
}