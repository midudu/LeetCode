/*
  You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.

  The path does not need to start or end at the root or a leaf, but it must go
downwards (traveling only from parent nodes to child nodes).

  The tree has no more than 1,000 nodes and the values are in the range
-1,000,000 to 1,000,000.

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
        3. -3 -> 11
*/

import java.util.HashMap;
import java.util.Map;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Method 1
/*class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(new Solution().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum)
                + pathSumHelper(root, sum);
    }

    private int pathSumHelper(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int existingResult = (root.val == sum ? 1 : 0);

        return existingResult + pathSumHelper(root.left, sum - root.val)
                + pathSumHelper(root.right, sum - root.val);
    }
}*/

// Method 2
class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(new Solution().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);

        return pathSumHelper(root, 0, sum, frequency);
    }

    private int pathSumHelper(
            TreeNode currentNode, int existingSum, int target,
            Map<Integer, Integer> frequency) {

        if (currentNode == null) {
            return 0;
        }

        existingSum += currentNode.val;
        int result = frequency.getOrDefault(existingSum - target,
                0);

        frequency.put(existingSum, frequency.getOrDefault(existingSum,
                0) + 1);

        result += pathSumHelper(currentNode.left, existingSum, target, frequency)
                + pathSumHelper(currentNode.right, existingSum, target, frequency);

        frequency.put(existingSum, frequency.get(existingSum) - 1);

        return result;
    }
}
