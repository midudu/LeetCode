/*Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

        Example:

        Input:

        1
        \
        3
        /
        2

        Output:
        1

        Explanation:
        The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
        Note: There are at least two nodes in this BST.*/


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

        new Solution().findRelativeRanks(new int[]{2, 4, 5, 1, 0});
    }
}


class Solution {

    private List<Integer> tree = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {

        this.getMinimumDifferenceHelper(root);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < tree.size() - 1; i++) {
            int temp = Math.abs(tree.get(i + 1) - tree.get(i));
            result = Math.min(result, temp);
        }

        return result;
    }

    private void getMinimumDifferenceHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        getMinimumDifferenceHelper(root.left);

        tree.add(root.val);

        getMinimumDifferenceHelper(root.right);
    }
}