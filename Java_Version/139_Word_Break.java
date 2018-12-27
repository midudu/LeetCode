/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.
        Example 1:

        Input: s = "leetcode", wordDict = ["leet", "code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple", "pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        Output: false*/


import java.util.HashSet;
import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        // Step 1: Convert List to HashSet
        HashSet<String> wordSet = new HashSet<>(wordDict);

        // Step 2: Statistic the minimum length of the words so as to decrease
        // unnecessary loop
        int minLengthOfWords = Integer.MAX_VALUE;
        for (String string : wordDict) {
            if (string.length() < minLengthOfWords) {
                minLengthOfWords = string.length();
            }
        }

        boolean[] breakable = new boolean[s.length() + 1];

        breakable[0] = true;

        for (int i = 1; i < breakable.length; i++) {

            // Decrease j rather than increase j
            for (int j = i - minLengthOfWords; j >= 0; j--) {

                if (breakable[j] && wordSet.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }

        return breakable[breakable.length - 1];
    }
}