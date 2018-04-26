/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

  Example 1:

  Input:

       Tree 1                     Tree 2
        1                         2
        / \                       / \
        3   2                     1   3
        /                           \   \
        5                             4   7
        Output:
        Merged tree:
        3
        / \
        4   5
        / \   \
        5   4   7

 Note: The merging process must start from the root nodes of both trees.*/


 
* 
* 思想：

* (1) 递归，但是不需要helper函数，直接在主函数中递归即可
*
* (2) 递归的思想是： 对于当前的两个根节点 t1 和 t2， 如果有一个为空，直接返回另一个结束；如果都不为空，创建新的根节点，值等于t1和t2的值之和，新的根节点的左儿子是 函数作用于 t1.left和t2.left，右儿子是 函数作用于 t1.right和t2.right;最后return这个新的根节点

------

    class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        
        return root;
    }
