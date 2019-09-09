/*
  Given a string which consists of lowercase or uppercase letters, find the
length of the longest palindromes that can be built with those letters.

  This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
  Assume the length of given string will not exceed 1,010.

Example:

        Input:
        "abccccdd"

        Output:
        7

        Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {

    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] charCount = new int[256];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)]++;
        }

        int result = 0;
        boolean oddFlag = false;
        for (int i = 'A'; i <= 'z'; i++) {
            if ((charCount[i] & 1) == 0) {
                result += charCount[i];
            } else {
                oddFlag = true;
                result += charCount[i] - 1;
            }
        }

        return (oddFlag ? result + 1 : result);
    }
}
