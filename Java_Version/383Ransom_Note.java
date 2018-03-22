/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

        Each letter in the magazine string can only be used once in your ransom note.

        Note:
        You may assume that both strings contain only lowercase letters.

        canConstruct("a", "b") -> false
        canConstruct("aa", "ab") -> false
        canConstruct("aa", "aab") -> true*/


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
    public boolean canConstruct(String ransomNote, String magazine) {

        int hashTable[] = new int[256];

        int magazineLength = magazine.length();
        for (int i = 0; i < magazineLength; i++) {
            hashTable[magazine.charAt(i)]++;
        }

        int ransomNoteLength = ransomNote.length();
        for (int i = 0; i < ransomNoteLength; i++) {
            hashTable[ransomNote.charAt(i)]--;
            if (hashTable[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}