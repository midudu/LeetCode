/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


  Example:

  Given the sorted array: [-10,-3,0,5,9],

  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

   0
   / \
 -3   9
 /   /
10  5*/

 
* 
* 思想：

* (1) 分治法，利用递归，将数组中间的值作为新的根节点，再分别调用递归函数处理左半部分和右半部分


-------

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length < 1)
            return null;

        int numsLength = nums.length;

        return sortedArrayToBSTHelper(nums, 0, numsLength - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int mid = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, startIndex, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, endIndex);

        return root;
    }