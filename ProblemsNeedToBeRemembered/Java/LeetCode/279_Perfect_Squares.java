/*
  Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.

Example 2:

        Input: n = 13
        Output: 2
        Explanation: 13 = 4 + 9.
*/

import java.util.*;

// method 1： bfs
/*class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().numSquares(13));
    }

    public int numSquares(int n) {

        if (n <= 0) {
            throw new RuntimeException("illegal input");
        }

        List<Integer> squareNumbers = getSquareNumbersList(n);
        HashSet<Integer> squareNumbersSet = new HashSet<>(squareNumbers);

        int layer = 1;
        HashSet<Integer> currentLayer = new HashSet<>();
        currentLayer.add(n);

        while (true) {

            if (areTwoSetsIntersected(currentLayer, squareNumbersSet)) {
                break;
            }

            layer++;
            currentLayer = generateNextLayer(currentLayer, squareNumbers);
        }

        return layer;
    }

    private List<Integer> getSquareNumbersList(int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 1; ; i++) {

            int squareOfI = i * i;
            if (squareOfI > n) {
                break;
            }

            result.add(squareOfI);
        }

        return result;
    }

    private boolean areTwoSetsIntersected(HashSet<Integer> set1, HashSet<Integer> set2) {

        return set1.size() > set2.size() ? areTwoSetsIntersectedHelper(set1, set2) :
                areTwoSetsIntersectedHelper(set2, set1);
    }

    private boolean areTwoSetsIntersectedHelper(HashSet<Integer> longSet, HashSet<Integer> shortSet) {

        for (Integer num : longSet) {
            if (shortSet.contains(num)) {
                return true;
            }
        }

        return false;
    }

    private HashSet<Integer> generateNextLayer(HashSet<Integer> currentLayer, List<Integer> squareNumbers) {

        HashSet<Integer> result = new HashSet<>();
        for (int num : currentLayer) {

            for (int squareNum : squareNumbers) {
                if (squareNum > num) {
                    break;
                }
                result.add(num - squareNum);
            }
        }

        return result;
    }
}*/

// Method 2: dp
class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().numSquares(12));
    }

    public int numSquares(int n) {

        if (n <= 0) {
            throw new RuntimeException("illegal input");
        }

        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 1; i < result.length; i++) {

            for (int j = 1; ; j++) {

                int jSqaure = j * j;
                if (jSqaure > i) {
                    break;
                }

                result[i] = Math.min(result[i], result[i - jSqaure] + 1);
            }
        }

        return result[n];
    }
}
