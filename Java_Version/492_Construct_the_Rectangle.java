/*For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

        1. The area of the rectangular web page you designed must equal to the given target area.

        2. The width W should not be larger than the length L, which means L >= W.

        3. The difference between length L and width W should be as small as possible.
        You need to output the length L and the width W of the web page you designed in sequence.
        Example:
        Input: 4
        Output: [2, 2]
        Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
        But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
        Note:
        The given area won't exceed 10,000,000 and is a positive integer
        The web page's width and length you designed must be positive integers.*/


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
    public int[] constructRectangle(int area) {

        int standardWidth = (int) Math.sqrt(area);

        int[] result = new int[2];
        result[0] = area;
        result[1] = 1;

        for (int i = 2; i <= standardWidth; i++) {

            if (area % i == 0) {
                result[0] = area / i;
                result[1] = i;
            }
        }

        return result;
    }
}