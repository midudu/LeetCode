/*You are given a binary tree in which each node contains an integer value.

        Find the number of paths that sum to a given value.

        The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

        The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

        Example:

        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

        10
        /  \
        5   -3
        / \    \
        3   2   11
        / \   \
        3  -2   1

        Return 3. The paths that sum to 8 are:

        1.  5 -> 3
        2.  5 -> 2 -> 1
        3. -3 -> 11*/

import java.util.List;

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

        System.out.println((int) ('A'));
        System.out.println((int) ('a'));
    }
}


class Solution {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return pathSumHelper(root, sum) + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int pathSumHelper(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        } else {
            if (root.val == sum) {
                return 1 + pathSumHelper(root.left, 0)
                        + pathSumHelper(root.right, 0);
            } else {
                return pathSumHelper(root.left, sum - root.val)
                        + pathSumHelper(root.right, sum - root.val);
            }
        }
    }
}