import java.util.HashMap;

class TreeNode {

    TreeNode left;
    TreeNode right;
}

public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBalancedSolutionHelper(root);
    }

    private boolean isBalancedSolutionHelper(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;

        } else if (root.left != null && root.right == null) {
            return getHeight(root.left) <= 1;

        } else if (root.left == null && root.right != null) {
            return getHeight(root.right) <= 1;

        } else {

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            return isBalancedSolutionHelper(root.left) && isBalancedSolutionHelper(root.right)
                    && Math.abs(leftHeight - rightHeight) <= 1;
        }
    }

    private HashMap<TreeNode, Integer> height = new HashMap<TreeNode, Integer>();

    private int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (height.containsKey(root)) {
            return height.get(root);
        } else {

            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
}