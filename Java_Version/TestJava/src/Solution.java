/*
  Implement strStr().

  Return the index of the first occurrence of needle in haystack, or -1 if
needle is not part of haystack.

  Example 1:

  Input: haystack = "hello", needle = "ll"
  Output: 2

  Example 2:

  Input: haystack = "aaaaa", needle = "bba"
  Output: -1
*/

class Solution {

    public int strStr(String haystack, String needle) {

        if (haystack == null
                || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }

        if (haystack.isEmpty()) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }

        int end = haystack.length() - needle.length() + 1;
        for (int i = 0; i < end; i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {

                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return i;
                }
            }
        }

        return -1;
    }
}