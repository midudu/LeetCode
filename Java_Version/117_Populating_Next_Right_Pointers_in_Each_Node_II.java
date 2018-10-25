/*
Given a binary tree

struct TreeLinkNode {
    TreeLinkNode *left;
    TreeLinkNode *right;
    TreeLinkNode *next;
}

Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.

Example:

Given the following binary tree,

          1
        /  \
       2    3
      / \    \
     4   5    7

After calling your function, the tree should look like:

        1 -> NULL
      /  \
     2 -> 3 -> NULL
    / \    \
   4-> 5 -> 7 -> NULL*/

class TreeLinkNode {

    int val;

    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        connectHelper(root);
    }

    private void connectHelper(TreeLinkNode root) {

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {

            findNextRightNode(root.right, root);

            connectHelper(root.right);
        }


        if (root.left != null) {

            if (root.right != null) {
                root.left.next = root.right;
            } else {
                findNextRightNode(root.left, root);
            }

            connectHelper(root.left);
        }
    }

    private void findNextRightNode(TreeLinkNode currentNode, TreeLinkNode root) {

        while (root.next != null) {

            if (root.next.left != null) {
                currentNode.next = root.next.left;
                return;
            }

            if (root.next.right != null) {
                currentNode.next = root.next.right;
                return;
            }

            root = root.next;
        }
    }
}
