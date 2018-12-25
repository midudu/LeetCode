/*
Given a string s, partition s such that every substring of the partition is a palindrome.

        Return all possible palindrome partitioning of s.

        Example:

        Input: "aab"
        Output:
        [
        ["aa","b"],
        ["a","a","b"]
        ]*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {

        // Step 0: Check input parameters
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        // Step 1: Get an array which represents if the substring between i and
        // j is palindrome
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        getIfPalindromeInsideRange(s, isPalindrome);

        // Step 2: dfs
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, isPalindrome, result, new ArrayList<>());

        return result;
    }

    private void getIfPalindromeInsideRange(
            String s, boolean[][] isPalindrome) {

        for (int i = s.length() - 1; i >= 0; --i) {

            isPalindrome[i][i] = true;

            for (int j = i + 1; j < s.length(); ++j) {

                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));

                if (isPalindrome[i][j] && j > i + 1) {
                    isPalindrome[i][j] &= isPalindrome[i + 1][j - 1];
                }
            }
        }
    }

    private void dfs(String s, int start, boolean[][] isPalindrome,
                     List<List<String>> result,
                     List<String> oneSplit) {

        if (start == s.length()) {

            List<String> tmp = new ArrayList<>(oneSplit);
            result.add(tmp);
            return;
        }

        for (int i = start; i < s.length(); ++i) {

            if (!isPalindrome[start][i]) {
                continue;
            }

            oneSplit.add(s.substring(start, i + 1));
            dfs(s, i + 1, isPalindrome, result, oneSplit);
            oneSplit.remove(oneSplit.size() - 1);
        }
    }
}