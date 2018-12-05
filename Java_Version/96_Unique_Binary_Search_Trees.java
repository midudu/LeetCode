/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

        Example:

        Input: 3
        Output: 5
        Explanation:
        Given n = 3, there are a total of 5 unique BST's:

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3*/

class Solution {

    public int numTrees(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }

        return result[n];
    }
}