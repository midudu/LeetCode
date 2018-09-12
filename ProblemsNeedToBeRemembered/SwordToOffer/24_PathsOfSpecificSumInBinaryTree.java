/* 
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。

路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前) */

import java.util.ArrayList;

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
    
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> currentResult = new ArrayList<Integer>();
        FindPathHelper(root, target, currentResult);
        
        return result;
    }
    
    private void FindPathHelper(TreeNode root,int target,ArrayList<Integer> currentResult) {
        
        currentResult.add(root.val);
        
        if (root.left == null  && root.right == null) {
            
            if ( root.val == target ) {
				// Must copy ArrayList first and then add into result !!!
                ArrayList<Integer> currentResultCopy = new ArrayList<>(currentResult);
				
				if ( result.isEmpty() ) {
					result.add(currentResultCopy);
				} else {
					for ( int i = 0; i < result.size(); i++ ) {
					    if ( result.get(i).size() < currentResultCopy.size() ) {
							result.add(i, currentResultCopy);
							break;
						}
                        if (i ==  result.size() - 1) {
                            result.add(currentResultCopy);
                            break;
                        }
					}
				}
            }
        } else if (root.left == null && root.right != null) {
            
            FindPathHelper(root.right, target - root.val, currentResult);
            
        } else if (root.left != null && root.right == null) {
            
            FindPathHelper(root.left, target - root.val, currentResult);
        } else {
            FindPathHelper(root.left, target - root.val, currentResult);
            FindPathHelper(root.right, target - root.val, currentResult);
        }
        
        currentResult.remove(currentResult.size() - 1);
    }
}