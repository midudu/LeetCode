/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        For example, given the following triangle

        [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
        ]
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

        Note:

        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/

import java.util.List;
import java.util.ArrayList;

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        ArrayList<Integer> sumPerRow = new ArrayList<>();
        sumPerRow.add(triangle.get(0).get(0));

        for (int row = 1; row < triangle.size(); row++) {

            ArrayList<Integer> sumNewRow = new ArrayList<>();

            for (int col = 0; col < triangle.get(row).size(); col++) {

                int currentSum = 0;

                if (col == 0) {
                    currentSum = triangle.get(row).get(col) + sumPerRow.get(col);
                } else if (col == triangle.get(row).size() - 1) {
                    currentSum = triangle.get(row).get(col) + sumPerRow.get(col - 1);
                } else {
                    currentSum = Math.min(
                            triangle.get(row).get(col) + sumPerRow.get(col - 1),
                            triangle.get(row).get(col) + sumPerRow.get(col));
                }

                sumNewRow.add(currentSum);
            }

            sumPerRow = sumNewRow;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < sumPerRow.size(); i++) {
            if (sumPerRow.get(i) < result) {
                result = sumPerRow.get(i);
            }
        }

        return result;
    }


}