/*Determine whether an integer is a palindrome. Do this without extra space.

        click to show spoilers.

        Some hints:
        Could negative integers be palindromes? (ie, -1)

        If you are thinking of converting the integer to string, note the restriction of using extra space.

        You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

        There is a more generic way of solving this problem.*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Main {
    public static void main(String[] args) {
        int x = 1;

        Solution solution = new Solution();

        boolean receive = solution.isPalindrome(x);


        System.out.println("haha");

    }


}


class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int result = 0, tail = 0;
        int xCopy = x;
        while (x != 0) {

            tail = x % 10;
            result = result * 10 + tail;
            x /= 10;
        }

        return xCopy == result;
    }
}