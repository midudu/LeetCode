class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val) {
            result = ifTwoTreesEqual(root1, root2);
        }

        if (!result) {
            result = HasSubtree(root1.left, root2);
        }

        if (!result) {
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    private boolean ifTwoTreesEqual(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return root1.val == root2.val
                && ifTwoTreesEqual(root1.left, root2.left)
                && ifTwoTreesEqual(root1.right, root2.right);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
    }
}