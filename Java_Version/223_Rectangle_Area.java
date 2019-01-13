/*

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner
as shown in the figure.

Rectangle Area

        Example:

        Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
        Output: 45

        Note:

Assume that the total area is never beyond the maximum possible value of int.*/


class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        long s1 = (long) (C - A) * (D - B);

        long s2 = (long) (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);

        long sOverlap = 0L;

        if (left >= right) {
            return (int) (s1 + s2);
        }

        int up = Math.min(D, H);
        int bottom = Math.max(B, F);

        if (up > bottom) {

            sOverlap = (long) (right - left) * (up - bottom);
        }

        return (int) (s1 - sOverlap + s2);
    }
}