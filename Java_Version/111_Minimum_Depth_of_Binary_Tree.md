/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a binary tree, find its minimum depth.

  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/

 
* 
* 思想：

* (1) 比较简单，根据有几个儿子划分几种情况，进行自递归


-------

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        else if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
