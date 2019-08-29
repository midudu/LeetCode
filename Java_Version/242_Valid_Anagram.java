/*
  Given two strings s and t, write a function to determine if t is an anagram of s.

  For example,

        s = "anagram", t = "nagaram", return true.
        s = "rat", t = "car", return false.

Note:
  You may assume the string contains only lowercase alphabets.

Follow up:
  What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCharCount = new int[256];
        int[] tCharCount = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sCharCount[s.charAt(i)]++;
            tCharCount[t.charAt(i)]++;
        }

        for (int character = 'a'; character <= 'z'; character++) {

            if (sCharCount[character] != tCharCount[character]) {
                return false;
            }
        }

        return true;
    }
}
