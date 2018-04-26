/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*
Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 For example:
  Given binary tree [3,9,20,null,null,15,7],

   3
  / \
  9  20
  /  \
 15   7

 return its depth = 3.*/

 
* 
* 思想：

* (1) 比较简单，自递归即可

-------

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
 
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
       
    }
