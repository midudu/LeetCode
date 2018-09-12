import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> trace = new ArrayList<>();
        if (root != null) {
            dfs(root, expectNumber, ret, trace);
        }

        return ret;
    }

    private void dfs(TreeNode root, int s,
                     ArrayList<ArrayList<Integer>> ret,
                     ArrayList<Integer> trace) {

        trace.add(root.val);
        if (root.left != null && root.right != null) {
            if (s == root.val)
                ret.push_back(trace);
        }
        if (root -> left)
            dfs(root -> left, s - root -> val, ret, trace);
        if (root -> right)
            dfs(root -> right, s - root -> val, ret, trace);
        trace.pop_back();
    }
};
