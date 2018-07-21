/* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode tempNode = queue.poll();
                
                if ( tempNode.left != null ) {
                    queue.offer(tempNode.left);
                }
                if ( tempNode.right != null ) {
                    queue.offer(tempNode.right);
                }
                result.add(tempNode.val);
            }
        }
        
        return result;
    }
}