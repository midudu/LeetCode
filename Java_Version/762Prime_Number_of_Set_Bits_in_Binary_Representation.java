/*
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

        (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

        Example 1:

        Input: L = 6, R = 10
        Output: 4
        Explanation:
        6 -> 110 (2 set bits, 2 is prime)
        7 -> 111 (3 set bits, 3 is prime)
        9 -> 1001 (2 set bits , 2 is prime)
        10->1010 (2 set bits , 2 is prime)
        Example 2:

        Input: L = 10, R = 15
        Output: 5
        Explanation:
        10 -> 1010 (2 set bits, 2 is prime)
        11 -> 1011 (3 set bits, 3 is prime)
        12 -> 1100 (2 set bits, 2 is prime)
        13 -> 1101 (3 set bits, 3 is prime)
        14 -> 1110 (3 set bits, 3 is prime)
        15 -> 1111 (4 set bits, 4 is not prime)
        Note:

        L, R will be integers L <= R in the range [1, 10^6].
        R - L will be at most 10000.
*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        String[] input = {"5", "2", "C", "D", "+"};

        Solution solution = new Solution();
        int receive = solution.calPoints(input);


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

    HashSet<Integer> primeNumbers = new HashSet<>();

    public int countPrimeSetBits(int L, int R) {

        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        primeNumbers.add(11);
        primeNumbers.add(13);
        primeNumbers.add(17);
        primeNumbers.add(19);

        int result = 0;

        for (int i = L; i <= R; i++){
            int oneBitCount = Integer.bitCount(i);

            if (primeNumbers.contains(oneBitCount)){
                result++;
            }
        }

        return result;
    }
}