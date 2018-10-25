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

class Solution {

    private int leftIndex = -1;
    private int rightIndex = -1;
    private int length = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {

            extendPalindromeStringFromCenter(i, i, s);
            extendPalindromeStringFromCenter(i, i + 1, s);
        }

        return s.substring(this.leftIndex, this.rightIndex + 1);
    }

    private void extendPalindromeStringFromCenter(
            int leftIndex, int rightIndex, String originalString) {

        while (true) {

            if (leftIndex < 0 || rightIndex >= originalString.length()
                    || originalString.charAt(leftIndex) != originalString.charAt(rightIndex)) {

                leftIndex++;
                rightIndex--;

                if (rightIndex - leftIndex + 1 > this.length) {
                    this.leftIndex = leftIndex;
                    this.rightIndex = rightIndex;
                    this.length = this.rightIndex - this.leftIndex + 1;
                }

                return;
            }

            leftIndex--;
            rightIndex++;
        }
    }
}