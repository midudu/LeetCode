/*
  Suppose you have a long flowerbed in which some of the plots are planted and
some are not. However, flowers cannot be planted in adjacent plots - they would
compete for water and both would die.

  Given a flowerbed (represented as an array containing 0 and 1, where 0 means
empty and 1 means not empty), and a number n, return if n new flowers can be
planted in it without violating the no-adjacent-flowers rule.

Example 1:
        Input: flowerbed = [1,0,0,0,1], n = 1
        Output: True

Example 2:
        Input: flowerbed = [1,0,0,0,1], n = 2
        Output: False

Note:

  The input array won't violate no-adjacent-flowers rule.
  The input array size is in the range of [1, 20000].
  n is a non-negative integer which won't exceed the input array size.
*/

class Solution {

    public static void main(String[] args) {

        int[] flowerbed = {1,0,0,0,1};

        System.out.println(new Solution().canPlaceFlowers(flowerbed, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed == null || flowerbed.length == 0) {
            return n == 0;
        }
        if (n > flowerbed.length) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            if (n == 0) {
                break;
            }

            if (canPlaceOnCurrentPosition(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }

    private boolean canPlaceOnCurrentPosition(int[] flowerbed, int position) {

        if (flowerbed[position] == 1) {
            return false;
        }

        if (position != 0 && flowerbed[position - 1] == 1) {
            return false;
        }

        if (position != flowerbed.length - 1 && flowerbed[position + 1] == 1) {
            return false;
        }

        return true;
    }
}