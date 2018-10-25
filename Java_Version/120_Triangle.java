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

		int layerNumbers = triangle.size();
        int[] sumResult = new int[layerNumbers];
		
		for (int i = 0; i < layerNumbers; i++) {
			
			sumResult[i] = triangle.get(layerNumbers - 1).get(i);
		}
		
		for ( int row = layerNumbers - 2; row >= 0; row-- ) {
			
			for ( int col = 0; col <= row; col++ ) {
				
				sumResult[col] = triangle.get(row).get(col) 
				               + Math.min(sumResult[col], sumResult[col+1]);
			}
		}
		
		return sumResult[0];
	}
}