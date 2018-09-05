class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    String Serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);

        return sb.toString();
    }

    private void Serialize2(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        Serialize2(root.left, sb);
        Serialize2(root.right, sb);
    }

    private int index = -1;

    TreeNode Deserialize(String str) {

        if (str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return Deserialize2(strs);
    }

    private TreeNode Deserialize2(String[] strs) {

        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);

        r1.left = r2;

        r2.left = r4;
        r2.right = r5;
        r4.left = r6;


        String result = new Solution().Serialize(r1);

        System.out.println(result);

        char[] resultChar = result.toCharArray();
        String[] resultString = new String[resultChar.length];
        for (int i = 0; i < resultChar.length; i++) {
            resultString[i] = Character.toString(resultChar[i]);
        }

        TreeNode root = new Solution().Deserialize(result);

        int a = 1;
    }
}