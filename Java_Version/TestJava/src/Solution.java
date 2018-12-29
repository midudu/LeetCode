import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();
            res.addFirst(curr.val);

            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }

        return res;
    }
}