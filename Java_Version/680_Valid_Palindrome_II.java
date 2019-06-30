/*
  Given a non-empty string s, you may delete at most one character. Judge
whether you can make it a palindrome.

Example 1:
        Input: "aba"
        Output: True

Example 2:
        Input: "abca"
        Output: True

        Explanation: You could delete the character 'c'.

Note:
  The string will only contain lowercase characters a-z. The maximum length of
the string is 50000.
*/

class Solution {

    public static void main(String[] args) {

        String s = "abcda";

        System.out.println(new Solution().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        return validPalindromeHelper(s, 0, s.length() - 1);
    }

    private boolean validPalindromeHelper(String s, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return true;
        }

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return validPalindromeHelper(s, startIndex + 1, endIndex - 1);
        } else {
            return ifStrictlyPalindrome(s, startIndex, endIndex - 1)
                    || ifStrictlyPalindrome(s, startIndex + 1, endIndex);
        }
    }

    private boolean ifStrictlyPalindrome(String s, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }
}