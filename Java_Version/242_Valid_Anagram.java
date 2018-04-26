/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given two strings s and t, write a function to determine if t is an anagram of s.

        For example,
        s = "anagram", t = "nagaram", return true.
        s = "rat", t = "car", return false.

        Note:
        You may assume the string contains only lowercase alphabets.

        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?*/


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
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return s == t;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] sHashTable = new int[256];
        int[] tHashTable = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sHashTable[s.charAt(i)]++;
            tHashTable[t.charAt(i)]++;
        }

        for (int character = 'a'; character <= 'z'; character++) {

            if (sHashTable[character] != tHashTable[character]) {
                return false;
            }
        }

        return true;
    }
}