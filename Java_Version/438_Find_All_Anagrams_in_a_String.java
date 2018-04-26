/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

        The order of output does not matter.

        Example 1:

        Input:
        s: "cbaebabacd" p: "abc"

        Output:
        [0, 6]

        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".
        Example 2:

        Input:
        s: "abab" p: "ab"

        Output:
        [0, 1, 2]

        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

        String s = "cbaebabacd", p = "abc";

        new Solution().findAnagrams(s, p);
    }
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<Integer>();
        if (s == null || p == null
                || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {

            return result;
        }

        int[] pPattern = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pPattern[p.charAt(i) - 'a']++;
        }

        int count = p.length();
        for (int i = 0; i < p.length() - 1; i++) {
            if (pPattern[s.charAt(i) - 'a'] > 0) {
                count--;
            }
            pPattern[s.charAt(i) - 'a']--;
        }

        int startPointer = 0, endPointer = p.length() - 1;

        while (endPointer < s.length()) {

            if (pPattern[s.charAt(endPointer) - 'a'] > 0) {
                count--;
            }
            pPattern[s.charAt(endPointer) - 'a']--;

            if (count == 0) {
                result.add(startPointer);
            }

            if (pPattern[s.charAt(startPointer) - 'a'] >= 0) {
                count++;
            }
            pPattern[s.charAt(startPointer) - 'a']++;

            startPointer++;
            endPointer++;
        }

        return result;
    }
}