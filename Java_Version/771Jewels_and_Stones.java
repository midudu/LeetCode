/*You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

        Example 1:

        Input: J = "aA", S = "aAAbbbb"
        Output: 3
        Example 2:

        Input: J = "z", S = "ZZ"
        Output: 0
        Note:

        S and J will consist of letters and have length at most 50.
        The characters in J are distinct.*/

import java.util.Arrays;
import java.lang.Math;
import java.lang.System;
import java.util.HashMap;
import java.lang.Integer;
import java.util.Iterator;
import java.util.Map;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 2};

        Solution solution = new Solution();
        int receive = solution.findShortestSubArray(nums);


        System.out.println("haha");
    }

}


class Solution {

    int[] map = new int[256];

    public int numJewelsInStones(String J, String S) {

        initMap(J);

        return countJewels(S);
    }

    private void initMap(String J) {

        int JLength = J.length();

        for (int i = 0; i < JLength; i++) {
            map[J.charAt(i)]++;
        }
    }

    private int countJewels(String S) {

        int SLength = S.length();

        int jewelsCount = 0;

        for (int i = 0; i < SLength; i++) {

            if (map[S.charAt(i)]>0){
                jewelsCount++;
            }
        }

        return jewelsCount;
    }
}