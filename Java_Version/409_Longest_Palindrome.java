/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

        This is case sensitive, for example "Aa" is not considered a palindrome here.

        Note:
        Assume the length of given string will not exceed 1,010.

        Example:

        Input:
        "abccccdd"

        Output:
        7

        Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.*/


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

        System.out.println((int) ('A'));
        System.out.println((int) ('a'));
    }
}


class Solution {
    public int longestPalindrome(String s) {

        int[] hashTable = new int[256];

        for (int i = 0; i < s.length(); i++) {

            hashTable[s.charAt(i)]++;
        }

        int result = 0;
        boolean oddFlag = false;
        for (int i = 'A'; i <= 'z'; i++) {

            if (hashTable[i] % 2 == 0) {
                result += hashTable[i];
            } else {
                oddFlag = true;
                result += hashTable[i] - 1;
            }
        }

        return (oddFlag ? result + 1 : result);
    }
}