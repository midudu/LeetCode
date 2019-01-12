/*Given a complete binary tree, count the number of nodes.

        Note:

        Definition of a complete binary tree from Wikipedia:
        In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

        Example:

        Input:
        1
        / \
        2   3
        / \  /
        4  5 6

        Output: 6*/

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int maxLayer = 0;
    private int lastLayerNodeNumbers = 0;
    private boolean stopFlag = false;

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        maxLayer = findMaxLayer(root);

        traverseLastLayerNodes(root);

        return lastLayerNodeNumbers + (1 << maxLayer) - 1;
    }

    private int findMaxLayer(TreeNode currentRoot) {

        if (currentRoot == null) {
            return 0;
        }

        return 1 + findMaxLayer(currentRoot.right);
    }

    private void traverseLastLayerNodes(TreeNode root) {

        traverseLastLayerNodesHelper(root, 1);
    }

    private void traverseLastLayerNodesHelper(TreeNode root, int currentLayer) {

        if (currentLayer != maxLayer) {

            traverseLastLayerNodesHelper(root.left, currentLayer + 1);
            traverseLastLayerNodesHelper(root.right, currentLayer + 1);

        } else {

            if (!stopFlag) {

                if (root.left != null) {
                    lastLayerNodeNumbers++;

                    if (root.right != null) {
                        lastLayerNodeNumbers++;
                    } else {
                        stopFlag = true;
                    }

                } else {
                    stopFlag = true;
                }
            }
        }
    }
}