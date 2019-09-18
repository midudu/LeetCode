/*
  Given a n x n matrix where each of the rows and columns are sorted in
ascending order, find the kth smallest element in the matrix.

  Note that it is the kth smallest element in the sorted order, not the kth
distinct element.

Example:

        matrix = [
        [ 1,  5,  9],
        [10, 11, 13],
        [12, 13, 15]
        ],
        k = 8,

        return 13.

Note:
  You may assume k is always valid, 1 ≤ k ≤ n2.
*/

import java.util.PriorityQueue;

// Method 1
/*class Solution {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2}, {3, 3}};

        System.out.println(new Solution().kthSmallest(matrix, 3));
    }

    public int kthSmallest(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new RuntimeException("illegal input");
        }
        if (matrix.length != matrix[0].length ||
                k < 1 || k > matrix.length * matrix.length) {
            throw new RuntimeException("illegal input");
        }
        if (k == 1) {
            return matrix[0][0];
        } else if (k == matrix.length * matrix.length) {
            return matrix[matrix.length - 1][matrix[0].length - 1];
        }

        int m = matrix.length * matrix.length - k + 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                priorityQueue.offer(matrix[i][j]);

                if (priorityQueue.size() > m) {
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }
}*/

// Method 2
class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int getLessEqual(int[][] matrix, int val) {

        int result = 0;
        int n = matrix.length, i = n - 1, j = 0;

        while (i >= 0 && j < n) {

            if (matrix[i][j] > val) {
                i--;
            } else {
                result += i + 1;
                j++;
            }
        }

        return result;
    }
}
