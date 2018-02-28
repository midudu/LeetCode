/*Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

        The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

        Example 1:
        Input: "UD"
        Output: true
        Example 2:
        Input: "LL"
        Output: false*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}



public class Main
{
    public static void main(String[] args)
    {
        String s = "bbbbb";

        Solution solution = new Solution();

        boolean receive = solution.judgeCircle(s);

        System.out.println("haha");

    }


}


class Solution {
    public boolean judgeCircle(String moves) {

        char[] movesChar = moves.toCharArray();

        int[] upDownDirections = new int[256];
        int[] leftRightDirections = new int[256];

        upDownDirections['U'] = 1;
        upDownDirections['D'] = -1;
        leftRightDirections['L'] = -1;
        leftRightDirections['R'] = 1;

        int leftRightCount = 0, upDownCount = 0;

        for (int i = 0; i < movesChar.length; i++)
        {
            leftRightCount += leftRightDirections[movesChar[i]];
            upDownCount += upDownDirections[movesChar[i]];
        }

        return ( leftRightCount == 0 && upDownCount == 0 );
    }
}