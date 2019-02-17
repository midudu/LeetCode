/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"*/


// O(n^2): Check every character which might be the middle of the palindromic
// substring
class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        // answerInformation[0]: the start index of the answer
        // answerInformation[0]: the length of the answer (for comparison in
        //                       every loop)
        int[] answerInformation = new int[2];

        for (int middleIndex = 0; middleIndex < s.length(); middleIndex++) {
            checkCurrentSituation(s, middleIndex, answerInformation);
        }

        return s.substring(answerInformation[0],
                answerInformation[0] + answerInformation[1]);
    }

    private void checkCurrentSituation(
            String s, int currentMiddleIndex, int[] answerInformation) {

        int leftIndex = currentMiddleIndex - 1;
        while (currentMiddleIndex < s.length() - 1
                && s.charAt(currentMiddleIndex) == s.charAt(currentMiddleIndex + 1)) {
            currentMiddleIndex++;
        }

        int rightIndex = currentMiddleIndex + 1;

        while (leftIndex >= 0 && rightIndex < s.length()
                && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }

        int currentLength = rightIndex - leftIndex - 1;
        if (currentLength > answerInformation[1]) {
            answerInformation[0] = leftIndex + 1;
            answerInformation[1] = currentLength;
        }
    }
}