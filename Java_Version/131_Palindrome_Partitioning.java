/*
  Given a string s, partition s such that every substring of the partition is a
palindrome. Return all possible palindrome partitioning of s.

Example:

        Input: "aab"
        Output:
        [
        ["aa","b"],
        ["a","a","b"]
        ]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {

        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int startIndex = s.length() - 1; startIndex >=0; startIndex--) {
            for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
                if (startIndex == endIndex) {
                    isPalindrome[startIndex][endIndex] = true;
                } else if (startIndex == endIndex - 1) {
                    isPalindrome[startIndex][endIndex] =
                            (s.charAt(startIndex) == s.charAt(endIndex));
                } else {
                    isPalindrome[startIndex][endIndex] = isPalindrome[startIndex+1][endIndex-1] &&
                            (s.charAt(startIndex) == s.charAt(endIndex));
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, isPalindrome, result, new ArrayList<>());

        return result;
    }

    private void dfs(String s, int startIndex, boolean[][] isPalindrome,
                     List<List<String>> result, List<String> existingWord) {

        if (startIndex == s.length()) {

            result.add(new ArrayList<>(existingWord));
            return;
        }

        for (int i = startIndex; i < s.length(); ++i) {

            if (!isPalindrome[startIndex][i]) {
                continue;
            }

            existingWord.add(s.substring(startIndex, i + 1));
            dfs(s, i + 1, isPalindrome, result, existingWord);
            existingWord.remove(existingWord.size() - 1);
        }
    }
}
