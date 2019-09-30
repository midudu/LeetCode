/*
  There are a number of spherical balloons spread in two-dimensional space. For
each balloon, provided input is the start and end coordinates of the horizontal
diameter. Since it's horizontal, y-coordinates don't matter and hence the
x-coordinates of start and end of the diameter suffice. Start is always smaller
than end. There will be at most 104 balloons.

  An arrow can be shot up exactly vertically from different points along the
x-axis. A balloon with x_start and x_end bursts by an arrow shot at x if
x_start ≤ x ≤ x_end. There is no limit to the number of arrows that can be shot.
An arrow once shot keeps travelling up infinitely. The problem is to find the
minimum number of arrows that must be shot to burst all balloons.

Example:

        Input:
        [[10,16], [2,8], [1,6], [7,12]]

        Output:
        2

        Explanation:
        One way is to shoot one arrow for example at x = 6 (bursting the
        balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the
        other two balloons).
*/

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {

        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        System.out.println(new Solution().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }

                return Integer.compare(o2[1], o1[1]);
            }
        });

        int result = 1;
        int[] lastRange = points[0];

        for (int i = 1; i < points.length; i++) {

            int[] currentRange = points[i];
            if (currentRange[0] > lastRange[1]) {
                result++;
                lastRange = currentRange;
            } else {
                lastRange[0] = currentRange[0];
                lastRange[1] = Math.min(lastRange[1], currentRange[1]);
            }
        }

        return result;
    }
}
