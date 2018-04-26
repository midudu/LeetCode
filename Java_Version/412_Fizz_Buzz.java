/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Write a program that outputs the string representation of numbers from 1 to n.

        But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

        Example:

        n = 15,

        Return:
        [
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
        ]*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        int receive = solution.findComplement(5);


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
    public List<String> fizzBuzz(int n) {

        int[] type = new int[n + 1];
        for (int i = 3; i <= n; i += 3) {
            type[i] += 1;
        }
        for (int i = 5; i <= n; i += 5) {
            type[i] += 2;
        }

        List<String> result = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            if (type[i] == 3) {
                result.add("FizzBuzz");
            } else if (type[i] == 2) {
                result.add("Buzz");
            } else if (type[i] == 1) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}