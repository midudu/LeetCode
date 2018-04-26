/*We are playing the Guess Game. The game is as follows:

        I pick a number from 1 to n. You have to guess which number I picked.

        Every time you guess wrong, I'll tell you whether the number is higher or lower.

        You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

        -1 : My number is lower
        1 : My number is higher
        0 : Congrats! You got it!
        Example:
        n = 10, I pick 6.

        Return 6.*/

import java.util.*;


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

        String s = "egg", t = "add";

        new Solution().isPowerOfThree(27);
    }
}



/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int startIndex = 1, endIndex = n;

        while (startIndex <= endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if ( guess(middleIndex) == 0 ) {
                return middleIndex;
            } else if ( guess(middleIndex) == 1 ) {
                startIndex = middleIndex + 1;
            } else if ( guess(middleIndex) == -1 ) {
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }
}