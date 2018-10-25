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

You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
and every parent has two children).

Example:

Given the following perfect binary tree,

        1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL*/

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {

    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

/*
// Method 1: Traverse

public class Solution {

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeLinkNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (i != size - 1) {
                    currentNode.next = queue.peek();
                }
            }
        }
    }
}*/

// Method 2
public class Solution {

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        connectHelper(root);
    }

    private void connectHelper(TreeLinkNode root) {

        if (root.left == null || root.right == null) {
            return;
        }

        root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connectHelper(root.left);
        connectHelper(root.right);
    }
}
