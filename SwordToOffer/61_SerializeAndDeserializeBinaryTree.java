/* 
题目描述
请实现两个函数，分别用来序列化和反序列化二叉树 */

/*
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
    
	String Serialize(TreeNode root) {
        
		if ( root == null ) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		serializeHelper(root, result);
		
		return result.toString();
	}
	
	private void serializeHelper(TreeNode root, StringBuilder currentResult) {
		
		if ( root == null ) {
			
			currentResult.append("#,");
			
		} else {
			
			currentResult.append(root.val);
			currentResult.append(",");
			
		    serializeHelper(root.left, currentResult);
		    serializeHelper(root.right, currentResult);
		}
	}
    
	
	TreeNode Deserialize(String str) {
		
		if ( str == null || str.length() == 0 ) {
			return null;
		}
		
		String[] strs = str.split(",");
		
		return deserializeHelper(strs);
    }
	
	private int currentIndex = -1;
    private TreeNode deserializeHelper(String[] strs) {
		
		currentIndex++;
		if ( strs[currentIndex].equals("#") ) {
			return null;
		} else {
			
			TreeNode root = new TreeNode(Integer.valueOf(strs[currentIndex]));
			root.left = deserializeHelper(strs);
			root.right = deserializeHelper(strs);
			return root;
		}
    }
}