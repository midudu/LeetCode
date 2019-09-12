/*
  Given a binary search tree (BST) with duplicates, find all the mode(s) (the
most frequently occurred element) in the given BST.

  Assume a BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than or equal
  to the node's key. The right subtree of a node contains only nodes with keys
  greater than or equal to the node's key. Both the left and right subtrees
  must also be binary search trees.

  For example:

        Given BST [1,null,2,2],

            1
             \
              2
             /
            2

        return [2].

Note:
  If a tree has more than one mode, you can return them in any order.

Follow up:
  Could you do that without using any extra space? (Assume that the implicit
stack space incurred due to recursion does not count).
*/

import java.util.*;


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


// Method 1
/*
class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] result = new Solution().findMode(root);
    }

    public int[] findMode(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> numbers = new ArrayList<>();
        preOrder(root, numbers);

        int maxMode = 0;
        List<Integer> result = new ArrayList<>(numbers.size());

        int startIndex = 0;
        int currentIndex = 0;
        while (currentIndex < numbers.size()) {

            while (currentIndex < numbers.size() &&
                    numbers.get(currentIndex).intValue() == numbers.get(startIndex).intValue()) {
                currentIndex++;
            }

            int count = currentIndex - startIndex;
            if (count == maxMode) {
                result.add(numbers.get(startIndex));
            } else if (count > maxMode) {
                result.clear();
                result.add(numbers.get(startIndex));
                maxMode = count;
            }
            startIndex = currentIndex;
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private void preOrder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        preOrder(root.left, result);
        result.add(root.val);
        preOrder(root.right, result);
    }
}*/

// Method 2
class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] result = new Solution().findMode(root);
        System.out.println(Arrays.toString(result));
    }

    private int maxMode = 0;
    private int currentMode = 0;
    private TreeNode prevNode = null;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        findModeHelper(root);

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private void findModeHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        findModeHelper(root.left);

        if (prevNode == null || root.val != prevNode.val) {
            currentMode = 1;
        } else {
            currentMode++;
        }

        if (currentMode == maxMode) {
            if (!result.isEmpty() && result.get(result.size() - 1) != root.val) {
                result.add(root.val);
            }
        } else if (currentMode > maxMode) {
            maxMode = currentMode;
            result.clear();
            result.add(root.val);
        }

        prevNode = root;

        findModeHelper(root.right);
    }
}
