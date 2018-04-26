/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

        For example,
        Given "egg", "add", return true.

        Given "foo", "bar", return false.

        Given "paper", "title", return true.

        Note:
        You may assume both s and t have the same length.*/


import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        String s = "egg", t = "add";

        new Solution().isIsomorphic(s, t);
    }
}


class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (hashMap1.containsKey(sChar)) {
                if (hashMap1.get(sChar) != tChar) {
                    return false;
                }
            } else {
                hashMap1.put(sChar, tChar);
            }

            if (hashMap2.containsKey(tChar)) {
                if (hashMap2.get(tChar) != sChar) {
                    return false;
                }
            } else {
                hashMap2.put(tChar, sChar);
            }
        }

        return true;
    }
}