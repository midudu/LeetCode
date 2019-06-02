/*
  Given a string s and a string t, check if s is sub-sequence of t.

  You may assume that there is only lower case English letters in both s and t.
t is potentially a very long (length ~= 500,000) string, and s is a short
string (<=100).

  A sub-sequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
        s = "abc", t = "ahbgdc"

        Return true.

Example 2:
        s = "axc", t = "ahbgdc"

        Return false.

Follow up:
        If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
and you want to check one by one to see if T has its subsequence. In this
scenario, how would you change your code?
*/

class Solution {

    public static void main(String[] args) {

        String s = "axc", t = "ahbgdc";

        boolean result = new Solution().isSubsequence(s, t);

        System.out.println(result);
    }

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null ) {
            return false;
        }

        if (s.length() == 0 || t.length() == 0) {
            return s.length() == 0;
        }

        return isSubSequenceHelper(s, 0, t, 0);
    }

    private boolean isSubSequenceHelper(
            String s, int sIndex, String t, int tIndex) {

        if (sIndex == s.length()) {
            return true;
        }

        if (tIndex == t.length()) {
            return false;
        }

        char currentChar = s.charAt(sIndex);

        for (int i = tIndex; i < t.length(); i++) {

            if (t.charAt(i) == currentChar) {
                return isSubSequenceHelper(s, sIndex + 1, t, i + 1);
            }
        }

        return false;
    }
}