/*
  In the computer world, use restricted resource you have to generate maximum 
benefit is what we always want to pursue. 
  
  For now, suppose you are a dominator of m 0s and n 1s respectively. On the 
other hand, there is an array with strings consisting of only 0s and 1s.

  Now your task is to find the maximum number of strings that you can form with
given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
  1. The given numbers of 0s and 1s will both not exceed 100
  2. The size of given string array won't exceed 600.
 

Example 1:
  Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
  Output: 4

  Explanation: This are totally 4 strings can be formed by the using of 5 0s 
  and 3 1s, which are “10,”0001”,”1”,”0”
 
Example 2:

  Input: Array = {"10", "0", "1"}, m = 1, n = 1
  Output: 2

  Explanation: You could form "10", but then you'd have nothing left. Better 
  form "0" and "1".
*/

// Method 1: Time limit exceed
/*
class Solution {

    public int findMaxForm(String[] strs, int m, int n) {

        if (m < 0 || n < 0) {
            throw new RuntimeException("illegal input");
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if (strs == null || strs.length == 0) {
            return 0;
        }

        return findMaxFormHelper(strs, 0, m, n);
    }

    private int findMaxFormHelper(String[] strs, int index, int m, int n) {

        if (index == strs.length) {
            return 0;
        } 
        
        int[] zeroAndOneCount = countZeroAndOne(strs[index]);
        if (m >= zeroAndOneCount[0] && n >= zeroAndOneCount[1]) {
            return Math.max(1 + findMaxFormHelper(strs, index + 1, m - zeroAndOneCount[0], n - zeroAndOneCount[1]),
            findMaxFormHelper(strs, index + 1, m, n));
        } else {
            return findMaxFormHelper(strs, index + 1, m, n);
        }
    }

    private int[] countZeroAndOne(String str) {

        int[] result = new int[2];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }

        return result;
    }
}
*/

class Solution {

    public int findMaxForm(String[] strs, int m, int n) {

        if (m < 0 || n < 0) {
            throw new RuntimeException("illegal input");
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int[][] result = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] zeroAndOneCount = countZeroAndOne(str);
            for (int row = m; row >= zeroAndOneCount[0]; row--) {
                for (int col = n; col >= zeroAndOneCount[1]; col--) {
                    result[row][col] = Math.max(result[row][col], 
                      result[row - zeroAndOneCount[0]][col - zeroAndOneCount[1]] + 1);
                }
            }
        }

        return result[m][n];
    }

    private int[] countZeroAndOne(String str) {

        int[] result = new int[2];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }

        return result;
    }
}
