/*
  Given two non-empty binary trees s and t, check whether tree t has exactly
the same structure and node values with a subtree of s. A subtree of s is a
tree consists of a node in s and all of this node's descendants. The tree s
could also be considered as a subtree of itself.

Example 1:

        Given tree s:

              3
             / \
            4   5
           / \
          1   2

        Given tree t:

              4
             / \
            1   2

        Return true, because t has the same structure and node values with a
      subtree of s.

Example 2:

        Given tree s:

              3
             / \
            4   5
           / \
          1   2
         /
        0

        Given tree t:

             4
            / \
           1   2

        Return false.
*/


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

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.left.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new Solution().isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null || t == null) {
            return s == null && t == null;
        }

        return isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode currentRoot, TreeNode t) {

        if ( currentRoot == null ) {
            return false;
        }

        if (isSameTree(currentRoot, t)) {
            return true;
        }

        return isSubtreeHelper(currentRoot.left, t)
                || isSubtreeHelper(currentRoot.right, t);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
