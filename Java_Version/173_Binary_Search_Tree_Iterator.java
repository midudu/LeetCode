/*
Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

        BSTIterator iterator = new BSTIterator(root);
        iterator.next();    // return 3
        iterator.next();    // return 7
        iterator.hasNext(); // return true
        iterator.next();    // return 9
        iterator.hasNext(); // return true
        iterator.next();    // return 15
        iterator.hasNext(); // return true
        iterator.next();    // return 20
        iterator.hasNext(); // return false

Note:
    next() and hasNext() should run in average O(1) time and uses O(h) memory,
    where h is the height of the tree.

    You may assume that next() call will always be valid, that is,
    there will be at least a next smallest number in the BST when next() is called.*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class BSTIterator {

    private final Deque<Integer> deque = new LinkedList<>();

    public BSTIterator(TreeNode root) {

        BSTIteratorHelper(root);
    }

    private void BSTIteratorHelper(TreeNode currentNode) {

        if (currentNode != null) {

            BSTIteratorHelper(currentNode.left);

            deque.add(currentNode.val);

            BSTIteratorHelper(currentNode.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {

        return deque.pollFirst();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {

        return !deque.isEmpty();
    }
}

