/*Given n non-negative integers a1, a2, ..., an, where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.*/

import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {

        int startPointer = 0, endPointer = height.length - 1;
        int maxAreaValue = 0;

        while (startPointer < endPointer) {

            int leftHeight = height[startPointer];
            int rightHeight = height[endPointer];
            int currentArea = (endPointer - startPointer)
                    * Math.min(leftHeight, rightHeight);
            maxAreaValue = (currentArea > maxAreaValue ?
                    currentArea : maxAreaValue);

            if (leftHeight <= rightHeight) {
                while (startPointer < endPointer
                        && height[startPointer] <= leftHeight) {
                    startPointer++;
                }
            } else {
                while (startPointer < endPointer
                        && height[endPointer] <= rightHeight) {
                    endPointer--;
                }
            }
        }

        return maxAreaValue;
    }
}