import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.left.left.right = new TreeNode(9);

        List<TreeNode> trace = new Solution().findTrace(root, root.left.left.right);

        System.out.println();
    }

    public List<TreeNode> findTrace(TreeNode root, TreeNode p) {

        LinkedList<TreeNode> result = new LinkedList<>();

        if (p == null) {
            return result;
        }

        findTraceHelper(root, p, result);

        return result;
    }

    private boolean findTraceHelper(TreeNode root, TreeNode p, LinkedList<TreeNode> list) {

        if (root == null) {
            return false;
        }

        list.addLast(root);
        if (root == p) {
            return true;
        }

        boolean leftResult = findTraceHelper(root.left, p, list);
        if (leftResult) {
            return true;
        }

        boolean rightResult = findTraceHelper(root.right, p, list);
        if (rightResult) {
            return true;
        }

        list.removeLast();
        return false;
    }
}
