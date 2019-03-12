/*
Given a string s consists of upper/lower-case alphabets and empty space
characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space
characters only.

Example:
    Input: "Hello World"
    Output: 5

*/

class Solution {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int endIndex = s.length() - 1;
        while (endIndex >= 0 && s.charAt(endIndex) == ' ') {
            endIndex--;
        }
        if (endIndex < 0) {
            return 0;
        }

        int startIndex = endIndex - 1;
        while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
            startIndex--;
        }

        return (endIndex - startIndex);
    }
}