/*
  Given two strings s and t, determine if they are isomorphic.

  Two strings are isomorphic if the characters in s can be replaced to get t.

  All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same
character but a character may map to itself.

For example,
        Given "egg", "add", return true.

        Given "foo", "bar", return false.

        Given "paper", "title", return true.

Note:
  You may assume both s and t have the same length.
*/


import java.util.HashMap;

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isIsomorphic("bar", "foo"));
    }

    public boolean isIsomorphic(String s, String t) {

        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] map1 = new char[256];
        char[] map2 = new char[256];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {

            if (map1[sChar[i]] != 0 && map1[sChar[i]] != tChar[i]) {
                return false;
            } else {
                map1[sChar[i]] = tChar[i];
            }

            if (map2[tChar[i]] != 0 && map2[tChar[i]] != sChar[i]) {
                return false;
            } else {
                map2[tChar[i]] = sChar[i];
            }
        }

        return true;
    }
}
