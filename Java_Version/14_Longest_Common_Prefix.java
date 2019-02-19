/*Write a function to find the longest common prefix string amongst an array of
strings.

If there is no common prefix, return an empty string "".

        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"

        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

        Note:

        All given inputs are in lowercase letters a-z.*/


class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(result)) {

                result = result.substring(0,
                        result.length() - 1);
            }

            if (result.length() == 0) {
                return "";
            }
        }

        return result;
    }
}