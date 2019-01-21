/*
Given a positive integer n,
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

        Example 1:

        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.
        Example 2:

        Input: n = 13
        Output: 2
        Explanation: 13 = 4 + 9.*/

import java.util.*;

class Solution {

    public int numSquares(int n) {

        List<Integer> squareNumbers = new ArrayList<>();

        for (int i = 1; ; i++) {

            int i2 = i * i;
            if (i2 == n) {
                return 1;
            } else if (i2 < n) {
                squareNumbers.add(i2);
            } else {
                break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int currentLayer = 0;

        while (!queue.isEmpty()) {

            currentLayer++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int currentNumber = queue.poll();

                for (int j = squareNumbers.size() - 1; j >= 0; j--) {
                    if (squareNumbers.get(j) == currentNumber) {
                        return currentLayer;
                    } else if (squareNumbers.get(j) < currentNumber) {
                        queue.offer(currentNumber - squareNumbers.get(j));
                    }
                }
            }
        }

        return currentLayer;
    }
}