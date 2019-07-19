/*
  Given two words word1 and word2, find the minimum number of steps required to
make word1 and word2 the same, where in each step you can delete one character
in either string.

Example 1:

        Input: "sea", "eat"
        Output: 2

        Explanation: You need one step to make "sea" to "ea" and another step to
      make "eat" to "ea".

Note:
  The length of given words won't exceed 500.

  Characters in given words can only be lower-case letters.
*/

class Solution {

    public static void main(String[] args) {

        String word1 = "sea", word2 = "eat";

        System.out.println(new Solution().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            if (word1 == null && word2 == null) {
                return 0;
            } else {
                return word1 == null ? word2.length() : word1.length();
            }
        }

        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }

        // 求两个字符串的最长公共子序列的经典方法：动态规划
        int[][] longestCommonSequenceLength = new int[word1.length() + 1][word2.length() + 1];

        for (int word1Index = 1; word1Index < longestCommonSequenceLength.length; word1Index++) {
            for (int word2Index = 1; word2Index < longestCommonSequenceLength[0].length; word2Index++) {

                if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
                    longestCommonSequenceLength[word1Index][word2Index] =
                            1 + longestCommonSequenceLength[word1Index - 1][word2Index - 1];
                } else {
                    longestCommonSequenceLength[word1Index][word2Index] =
                            Math.max(longestCommonSequenceLength[word1Index - 1][word2Index],
                                    longestCommonSequenceLength[word1Index][word2Index - 1]);
                }
            }
        }

        return word1.length() - longestCommonSequenceLength[word1.length()][word2.length()]
                + word2.length() - longestCommonSequenceLength[word1.length()][word2.length()];
    }
}


