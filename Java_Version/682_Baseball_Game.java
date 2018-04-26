/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*You're now a baseball game point recorder.

        Given a list of strings, each string can be one of the 4 following types:

        Integer (one round's score): Directly represents the number of points you get in this round.
        "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
        "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
        "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
        Each round's operation is permanent and could have an impact on the round before and the round after.

        You need to return the sum of the points you could get in all the rounds.

        Example 1:
        Input: ["5","2","C","D","+"]
        Output: 30
        Explanation:
        Round 1: You could get 5 points. The sum is: 5.
        Round 2: You could get 2 points. The sum is: 7.
        Operation 1: The round 2's data was invalid. The sum is: 5.
        Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
        Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
        Example 2:
        Input: ["5","-2","4","C","D","9","+","+"]
        Output: 27
        Explanation:
        Round 1: You could get 5 points. The sum is: 5.
        Round 2: You could get -2 points. The sum is: 3.
        Round 3: You could get 4 points. The sum is: 7.
        Operation 1: The round 3's data is invalid. The sum is: 3.
        Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
        Round 5: You could get 9 points. The sum is: 8.
        Round 6: You could get -4 + 9 = 5 points. The sum is 13.
        Round 7: You could get 9 + 5 = 14 points. The sum is 27.
        Note:
        The size of the input list will be between 1 and 1000.
        Every integer represented in the list will be between -30000 and 30000.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        String[] input = {"5","2","C","D","+"};

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

    int result = 0;
    List<Integer> integerList = new ArrayList<Integer>();

    public int calPoints(String[] ops) {
        int opsLength = ops.length;

        for (int i = 0; i < opsLength; i++) {
            if (ops[i].charAt(0) == '+') {
                processAdd();
            } else if (ops[i].charAt(0) == 'D') {
                processD();
            } else if (ops[i].charAt(0) == 'C') {
                processC();
            } else {
                processNumber(new Integer(ops[i]));
            }
        }

        return result;
    }

    private void processAdd() {

        int listSize = integerList.size();
        int tempScore = integerList.get(listSize - 1) + integerList.get(listSize - 2);
        result += tempScore;
        integerList.add(tempScore);
    }

    private void processD() {
        int listSize = integerList.size();
        int tempScore = integerList.get(listSize - 1) * 2;
        result += tempScore;
        integerList.add(tempScore);
    }

    private void processC() {
        int listSize = integerList.size();
        int tempScore = integerList.remove(listSize - 1);
        result -= tempScore;
    }

    private void processNumber(Integer number) {

        result += number;
        integerList.add(number);
    }
}