/*
  Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
*/

class Solution {

    public String convertToTitle(int n) {

        if (n == 0) {
            return "";
        } else {
            n--;
            return convertToTitle(n / 26) + (char) ('A' + n % 26);
        }
    }
}
