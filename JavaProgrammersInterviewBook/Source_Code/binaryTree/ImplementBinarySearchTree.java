package binaryTree;

/* 实现二叉搜索树的1.数据插入 
2.前序遍历 
3.中序遍历 
4.后序遍历
5.层次遍历 
6.根据前序遍历和中序遍历求后序遍历 
7.求二叉树中节点的最大距离*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class ImplementBinarySearchTree {

    class TreeNode {
        TreeNode leftNode;
        TreeNode rightNode;
        int val;

        TreeNode(int val) {
            this.val = val;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    private TreeNode root;

    ImplementBinarySearchTree() {
        root = null;
    }

    //插入数据
    void insertData(int val) {

        if (this.root == null) {
            this.root = new TreeNode(val);
        } else {
            insertDataHelper(val, this.root);
        }
    }

    private void insertDataHelper(int val, TreeNode root) {

        if (root.val == val) {
            return;
        } else if (root.val < val) {
            if (root.rightNode == null) {
                root.rightNode = new TreeNode(val);
                return;
            } else {
                insertDataHelper(val, root.rightNode);
            }
        } else {
            if (root.leftNode == null) {
                root.leftNode = new TreeNode(val);
                return;
            } else {
                insertDataHelper(val, root.leftNode);
            }
        }
    }


    //中序遍历（中根遍历）
    void middleOrderTraverse() {

        middleOrderTraverseHelper(this.root);
    }

    private void middleOrderTraverseHelper(TreeNode node) {

        if (node == null) {
            return;
        }

        middleOrderTraverseHelper(node.leftNode);
        System.out.println(node.val);
        middleOrderTraverseHelper(node.rightNode);
    }

    //前序遍历（先根遍历）
    void preOrderTraverse() {

        preOrderTraverseHelper(this.root);
    }

    private void preOrderTraverseHelper(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.val);
        preOrderTraverseHelper(node.leftNode);
        preOrderTraverseHelper(node.rightNode);
    }


    //后序遍历（后根遍历）
    void postOrderTraverse() {

        postOrderTraverseHelper(this.root);
    }

    private void postOrderTraverseHelper(TreeNode node) {

        if (node == null) {
            return;
        }

        postOrderTraverseHelper(node.leftNode);
        postOrderTraverseHelper(node.rightNode);
        System.out.println(node.val);
    }


    //层次遍历
    void levelTraverse() {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                System.out.println(currentNode.val);
                if (currentNode.leftNode != null) {
                    queue.offer(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    queue.offer(currentNode.rightNode);
                }
            }
        }
    }


    void getPostTraverseAccordingToPreTraverseAndMiddleTraverse(int[] preOrderTraverse, int[] middleOrderTraverse) {

        if (preOrderTraverse == null || middleOrderTraverse == null
                || preOrderTraverse.length == 0 || middleOrderTraverse.length == 0
                || preOrderTraverse.length != middleOrderTraverse.length) {
            return;
        }

        TreeNode psudoRoot = new TreeNode(0);
        psudoRoot.leftNode = getPostTraverseAccordingToPreTraverseAndMiddleTraverseHelper(
                preOrderTraverse, 0, preOrderTraverse.length - 1,
                middleOrderTraverse, 0, middleOrderTraverse.length - 1);

        root = psudoRoot.leftNode;

        //this.postOrderTraverse();
    }

    private TreeNode getPostTraverseAccordingToPreTraverseAndMiddleTraverseHelper(
            int[] preOrderTraverse, int preStartIndex, int preEndIndex,
            int[] middleOrderTraverse, int middleStartIndex, int middleEndIndex) {

        TreeNode node = null;

        if (preStartIndex < preEndIndex) {

            node = new TreeNode(preOrderTraverse[preStartIndex]);

            int rootIndex = findRootIndex(middleOrderTraverse, preOrderTraverse[preStartIndex], middleStartIndex, middleEndIndex);

            node.leftNode = getPostTraverseAccordingToPreTraverseAndMiddleTraverseHelper(
                    preOrderTraverse, preStartIndex + 1, preStartIndex + rootIndex - middleStartIndex,
                    middleOrderTraverse, middleStartIndex, rootIndex - 1);
            node.rightNode = getPostTraverseAccordingToPreTraverseAndMiddleTraverseHelper(
                    preOrderTraverse, preStartIndex + rootIndex - middleStartIndex + 1, preEndIndex,
                    middleOrderTraverse, rootIndex + 1, middleEndIndex);
        } else if (preStartIndex == preEndIndex) {
            node = new TreeNode(preOrderTraverse[preStartIndex]);
        }

        if (node != null) {
            System.out.println(node.val);
        }
        return node;
    }


    private int findRootIndex(int[] middleOrderTraverse, int rootVal,
                              int startIndex, int endIndex) {

        for (int i = startIndex; i <= endIndex; i++) {

            if (middleOrderTraverse[i] == rootVal) {
                return i;
            }
        }

        return -1;
    }


    private int maxDistance = 0;
    private HashMap<TreeNode, Integer> leftMaxDistance = new HashMap<>();
    private HashMap<TreeNode, Integer> rightMaxDistance = new HashMap<>();

    int findMaxDistance() {

        if (root == null) {
            return 0;
        }

        findMaxDistanceHelper(root);

        return maxDistance;
    }

    private void findMaxDistanceHelper(TreeNode root) {

        if (root.leftNode == null) {
            leftMaxDistance.put(root, 0);
        } else {
            findMaxDistanceHelper(root.leftNode);
        }

        if (root.rightNode == null) {
            rightMaxDistance.put(root, 0);
        } else {
            findMaxDistanceHelper(root.rightNode);
        }

        if (root.leftNode != null) {
            leftMaxDistance.put(root, 1 + Math.max(leftMaxDistance.get(root.leftNode), rightMaxDistance.get(root.leftNode)));
        }
        if (root.rightNode != null) {
            rightMaxDistance.put(root, 1 + Math.max(leftMaxDistance.get(root.rightNode), rightMaxDistance.get(root.rightNode)));
        }

        maxDistance = Math.max(leftMaxDistance.get(root) + rightMaxDistance.get(root), maxDistance);
    }


    // Below is for testing
    public static void main(String[] args) {

        ImplementBinarySearchTree bst = new ImplementBinarySearchTree();

        int[] input = {9, 5, 6, 8, 4, 6, 2, 1};

        for (int number : input) {
            bst.insertData(number);
        }

        System.out.println("前序遍历");
        bst.preOrderTraverse();
        System.out.println("中序遍历");
        bst.middleOrderTraverse();
        System.out.println("后序遍历");
        bst.postOrderTraverse();
        System.out.println("层次遍历");
        bst.levelTraverse();

        int maxDistance = bst.findMaxDistance();

        ImplementBinarySearchTree bst2 = new ImplementBinarySearchTree();
        int[] preOrder = {9, 5, 4, 2, 1, 6, 8};
        int[] middleOrder = {1, 2, 4, 5, 6, 8, 9};

        System.out.println("后序遍历");
        bst2.getPostTraverseAccordingToPreTraverseAndMiddleTraverse(preOrder, middleOrder);

        System.out.println("haha");
    }
}