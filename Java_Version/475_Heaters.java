/*Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

        Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

        So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

        Note:
        Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
        Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
        As long as a house is in the heaters' warm radius range, it can be warmed.
        All the heaters follow your radius standard and the warm radius will the same.
        Example 1:
        Input: [1,2,3],[2]
        Output: 1
        Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
        Example 2:
        Input: [1,2,3,4],[1,4]
        Output: 1
        Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.*/


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

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);

        int result = 0;
        for (int house : houses) {

            int index = binarySearch(heaters, house);

            if (index == 0) {
                result = Math.max(heaters[0] - house, result);
            } else if (index == heaters.length) {
                result = Math.max(house - heaters[heaters.length - 1], result);
            } else {
                result = Math.max(result, Math.min(heaters[index] - house, house - heaters[index - 1]));
            }
        }

        return result;
    }

    private int binarySearch(int[] heaters, int house) {

        int start = 0, end = heaters.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (heaters[mid] < house) {
                start = mid + 1;
            } else if (heaters[mid] > house) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return start;
    }
}