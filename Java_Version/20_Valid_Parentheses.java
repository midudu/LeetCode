/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        List<List<Integer>> receive = solution.fourSum(nums, 4);


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

class Solution {

    HashMap<Character, Character> map = new HashMap<Character, Character>();

    public boolean isValid(String s) {

        this.buildHashMap();

        Stack<Character> count = new Stack<>();
        int sLength = s.length();
        char currentChar;

        for (int i = 0; i < sLength; i++) {

            currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '['){
                count.push(currentChar);
            } else {
                if (count.empty()){
                    return false;
                } else {
                    if (count.peek() == map.get(currentChar)){
                        count.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (!count.empty()) {
            return false;
        } else {
            return true;
        }

    }

    private void buildHashMap() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
}