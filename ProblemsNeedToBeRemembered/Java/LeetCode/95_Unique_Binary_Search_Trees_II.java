/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

        Example:

        Input: 3
        Output:
        [
        [1,null,3,2],
        [3,2,null,1],
        [3,1,null,null,2],
        [2,1,3],
        [1,null,2,null,3]
        ]
        Explanation:
        The above output corresponds to the 5 unique BST's shown below:

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3*/


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/* Let's pick up number i out of the sequence 1 ..n and use it as the root of the current tree. 
Then there are i - 1 elements available for the construction of the left subtree 
and n - i elements available for the right subtree */

class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n < 1) {
            return new ArrayList<>();
        }

        List<TreeNode> result = new ArrayList<>();

        generateTreesHelper(1, n, result);

        return result;
    }

    private void generateTreesHelper(
            int startIndex, int endIndex, List<TreeNode> result) {

        if (startIndex > endIndex) {
            result.add(null);
            return;
        }

        if (startIndex == endIndex) {
            result.add(new TreeNode(startIndex));
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {

            List<TreeNode> leftResult = new ArrayList<>();
            generateTreesHelper(startIndex, i - 1, leftResult);

            List<TreeNode> rightResult = new ArrayList<>();
            generateTreesHelper(i + 1, endIndex, rightResult);

            for (int j = 0; j < leftResult.size(); j++) {
                for (int k = 0; k < rightResult.size(); k++) {

                    TreeNode root = new TreeNode(i);
                    root.left = leftResult.get(j);
                    root.right = rightResult.get(k);
                    result.add(root);
                }
            }
        }
    }
}