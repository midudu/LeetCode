/*A self-dividing number is a number that is divisible by every digit it contains.

        For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

        Also, a self-dividing number is not allowed to contain the digit zero.

        Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

        Example 1:
        Input:
        left = 1, right = 22
        Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        Note:

        The boundaries of each input argument are 1 <= left <= right <= 10000.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 2};

        Solution solution = new Solution();
        int receive = solution.findShortestSubArray(nums);


        System.out.println("haha");
    }

}


class Solution {

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> selfDividingNumbers(int left, int right) {

        for (int i = left; i <= right; i++) {
            judgeSelfDividingNumbers(i);
        }

        return result;
    }

    private void judgeSelfDividingNumbers(int number) {

        if (number < 10) {
            result.add(number);
            return;
        }
        if (number % 10 == 0) {
            return;
        }

        int[] map = new int[10];

        int copyNumber = number;
        while (copyNumber != 0) {
            map[copyNumber % 10]++;
            copyNumber /= 10;
        }

        if (map[0] != 0) {
            return;
        }

        boolean receive = judgeByMap(number, map);
        if (receive) {
            result.add(number);
        }

    }

    private boolean judgeByMap(int number, int[] map) {
        if (map[9] != 0 && number % 9 != 0) {
            return false;
        }

        if (map[8] != 0 && number % 8 != 0) {
            return false;
        }

        if (map[7] != 0 && number % 7 != 0) {
            return false;
        }

        if (map[6] != 0) {
            if (map[9] != 0 && map[8] != 0) {
            } else {
                if (number % 6 != 0) {
                    return false;
                }
            }
        }

        if (map[5] != 0 && number % 5 != 0) {
            return false;
        }

        if (map[4] != 0) {
            if (map[8] != 0) {
            } else {
                if (number % 4 != 0) {
                    return false;
                }
            }
        }

        if (map[3] != 0) {
            if (map[6] != 0 || map[9] != 0) {
            } else {
                if (number % 3 != 0) {
                    return false;
                }
            }
        }

        if (map[2] != 0 && (number & 1) != 0) {
            return false;
        }

        return true;
    }
}