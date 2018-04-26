/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

  Example 1:
  
      Input:
        1
        / \
        0   2

        L = 1
        R = 2

        Output:
        1
        \
        2
        Example 2:
        Input:
        3
        / \
        0   4
        \
        2
        /
        1

        L = 1
        R = 3

        Output:
        3
        /
        2
        /
        1*/


 
* 
* 思想：

* (1) 递归的思想，由于二叉搜索树的特殊性，即一个根节点的左侧都小于根节点，右侧都小于根节点，所以  如果一个根节点大于R，直接作用于根节点的左儿子；如果一个根节点小于L，直接作用于根节点的右儿子；如果根节点在L、R之间，建立一个新的根节点，它的值为原根节点的值，左儿子为函数作用于原根节点左儿子上，右儿子为函数作用于原根节点右儿子上

------


    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        if (root.val > R) {

            return trimBST(root.left, L, R);
        } else if (root.val < L) {

            return trimBST(root.right, L, R);
        }

        TreeNode resultTreeNode =  new TreeNode(root.val);
        resultTreeNode.left = trimBST(root.left, L, R);
        resultTreeNode.right = trimBST(root.right, L, R);

        return resultTreeNode;
    }
