/*
  We are playing the Guess Game. The game is as follows:

    I pick a number from 1 to n. You have to guess which number I picked.

    Every time you guess wrong, I'll tell you whether the number I picked is
higher or lower.

    However, when you guess a particular number x, and you guess wrong, you pay
$x. You win the game when you guess the number I picked.

  Example:

    n = 10, I pick 8.

    First round:  You guess 5, I tell you that it's higher. You pay $5.
    Second round: You guess 7, I tell you that it's higher. You pay $7.
    Third round:  You guess 9, I tell you that it's lower. You pay $9.

    Game over. 8 is the number I picked.

    You end up paying $5 + $7 + $9 = $21.

  Given a particular n ≥ 1, find out how much money you need to have to
guarantee a win.
*/

class Solution {

    public static void main(String[] args) {

        new Solution().getMoneyAmount(7);
    }

    private int[][] result;

    public int getMoneyAmount(int n) {

        result = new int[n + 1][n + 1];

        return dfsHelper(1, n);
    }

    private int dfsHelper(int left, int right) {

        if (left >= right) {
            return 0;
        } else if (left + 1 == right) {
            return left;
        } else if (left + 2 == right) {
            return left + 1;
        }

        if (result[left][right] != 0) {
            return result[left][right];
        }

        int res = Integer.MAX_VALUE;

        for (int i = left + (right - left) / 2; i <= right; ++i) {
            res = Math.min(res, i + Math.max(dfsHelper(left, i - 1),
                    dfsHelper(i + 1, right)));
        }

        result[left][right] = res;

        return res;
    }
}