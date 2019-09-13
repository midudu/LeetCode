/*
  Given an integer, return its base 7 string representation.

Example 1:

        Input: 100
        Output: "202"

Example 2:
        Input: -7
        Output: "-10"

Note:
  The input will be in range of [-1e7, 1e7].
*/

class Solution {

    public String convertToBase7(int num) {

        if (num < 0) {
            return "-" + convertToBase7Helper(-num);
        } else if (num == 0) {
            return "0";
        } else {
            return convertToBase7Helper(num);
        }
    }

    private String convertToBase7Helper(int num) {

        if (num == 0) {
            return "";
        } else {
            return convertToBase7Helper(num / 7) + Character.toString((char) (num % 7 + '0'));
        }
    }
}
