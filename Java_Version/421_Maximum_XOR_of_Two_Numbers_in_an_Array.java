/*
  Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.

  Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

  Could you do this in O(n) runtime?

Example:

  Input: [3, 10, 5, 25, 2, 8]

  Output: 28

  Explanation: The maximum result is 5 ^ 25 = 28.
*/

class TrieNode {

    TrieNode leftNode, rightNode;
    int value;
}

class TrieTree {

    private TrieNode root = new TrieNode();

    public void insertNum(int num) {

        TrieNode currentNode = root;

        for (int i = 30; i >= 0; i--) {

            int currentBit = (num & (1 << i));

            if (currentBit != 0) {
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = new TrieNode();
                }
                currentNode = currentNode.leftNode;
            } else {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = new TrieNode();
                }
                currentNode = currentNode.rightNode;
            }
        }

        currentNode.value = num;
    }

    public int findAnswer(int num) {

        TrieNode currentNode = this.root;

        for (int i = 30; i >= 0; i--) {

            int currentBit = (num & (1 << i));

            if (currentBit != 0) {
                if (currentNode.rightNode != null) {
                    currentNode = currentNode.rightNode;
                } else {
                    currentNode = currentNode.leftNode;
                }
            } else {
                if (currentNode.leftNode != null) {
                    currentNode = currentNode.leftNode;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
        }

        return (num ^ currentNode.value);
    }
}

class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 10, 5, 25, 2, 8};

        System.out.println(new Solution().findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {

        if (nums == null || nums.length < 1) {
            throw new RuntimeException("input parameters are illegal");
        }

        TrieTree trieTree = new TrieTree();

        for (int num : nums) {
            trieTree.insertNum(num);
        }

        int result = Integer.MIN_VALUE;

        for (int num : nums) {

            int currentResult = trieTree.findAnswer(num);

            if (currentResult > result) {
                result = currentResult;
            }
        }

        return result;
    }
}