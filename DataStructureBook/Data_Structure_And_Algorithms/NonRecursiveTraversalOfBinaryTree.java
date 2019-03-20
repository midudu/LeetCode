import java.util.*;

class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }
}

class TraverseNonRecursively {

    // 测试
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(9);

        System.out.println("Pre-Order");
        new TraverseNonRecursively().preOrder(root);
        System.out.println();

        System.out.println("In-Order");
        new TraverseNonRecursively().inOrder(root);
        System.out.println();

        System.out.println("Post-Order");
        new TraverseNonRecursively().postOrder(root);
    }

    // 前序遍历：最简单，先把root放到stack中，然后每次把pop出来的结点的右、左子结点依次push进stack中
    public void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            System.out.println(currentNode.value);
        }
    }

    //中序遍历：用两个变量保存状态：当前待处理结点和一个保存待处理结点的栈，终止条件是当前待处理结点为null且待处理结点的栈为空。每次把当前待处理结点一路查询左子结点，并压到栈中，直到当前待处理结点为null；然后从栈中pop()一个元素作为当前待处理结点，打印它的值，并把当前结点的右子结点作为当前待处理结点，等待下一轮的处理
    public void inOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                System.out.println(currentNode.value);
                currentNode = currentNode.right;
            }
        }
    }

    // 后序遍历：用了一个巧妙的操作：依然采用前序遍历的思路，只不过顺序改成root-right-left，把结果保存下来以后，反转就会得到left-right-root，就是正确的后序遍历
    public void postOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            result.add(currentNode.value);
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}