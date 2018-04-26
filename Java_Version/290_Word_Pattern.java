/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a pattern and a string str, find if str follows the same pattern.

        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

        Examples:
        pattern = "abba", str = "dog cat cat dog" should return true.
        pattern = "abba", str = "dog cat cat fish" should return false.
        pattern = "aaaa", str = "dog cat cat dog" should return false.
        pattern = "abba", str = "dog dog dog dog" should return false.
        Notes:
        You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        String pattern = "abba", str = "dog cat cat dog";
        boolean re = new Solution().wordPattern(pattern, str);

        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> hashTable = new HashMap<>();
        int patternPointer = 0;
        int lastSpaceIndex = -1, currentSpaceIndex = 0;

        while (true) {
            currentSpaceIndex = str.indexOf(' ', lastSpaceIndex + 1);
            if (currentSpaceIndex != -1) {

                String temp = str.substring(lastSpaceIndex + 1, currentSpaceIndex);
                if (hashTable.containsKey(pattern.charAt(patternPointer))) {
                    if (!hashTable.get(pattern.charAt(patternPointer)).equals(temp)) {
                        return false;
                    }
                } else {
                    if (hashTable.containsValue(temp)){
                        return false;
                    }
                    hashTable.put(pattern.charAt(patternPointer), temp);
                }

                patternPointer++;
                if (patternPointer >= pattern.length()) {
                    return false;
                }
                lastSpaceIndex = currentSpaceIndex;

            } else {

                if (patternPointer != pattern.length() - 1) {
                    return false;
                }

                String temp = str.substring(lastSpaceIndex + 1, str.length());

                /*return (!hashTable.containsKey(pattern.charAt(patternPointer))
                        || hashTable.get(pattern.charAt(patternPointer)).equals(temp));*/

                if (!hashTable.containsKey(pattern.charAt(patternPointer))) {
                    return !hashTable.containsValue(temp);
                } else {
                    return hashTable.get(pattern.charAt(patternPointer)).equals(temp);
                }
            }
        }
    }
}