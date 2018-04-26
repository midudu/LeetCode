/*Given an integer, return its base 7 string representation.

        Example 1:
        Input: 100
        Output: "202"
        Example 2:
        Input: -7
        Output: "-10"
        Note: The input will be in range of [-1e7, 1e7].*/


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

        int[] houses = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heaters = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};


        new Solution().findRadius(houses, heaters);
    }
}


class Solution {
    public String convertToBase7(int num) {

        if (num < 0) {
            return "-" + convertToBase7(-num);
        } else if (num == 0) {
            return "0";
        } else {
            return convertToBase7Helper(num);
        }
    }

    private String convertToBase7Helper(int num) {

        if (num == 0) {
            return "";
        } else {
            return convertToBase7Helper(num / 7) + Character.toString((char) (num % 7 + '0'));
        }
    }
}