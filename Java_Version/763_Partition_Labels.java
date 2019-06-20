/*
  A string S of lowercase letters is given. We want to partition this string
into as many parts as possible so that each letter appears in at most one part,
and return a list of integers representing the size of these parts.

Example 1:

      Input: S = "ababcbacadefegdehijhklij"
      Output: [9,7,8]

      Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.
        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

        S will have length in range [1, 500].

        S will consist of lowercase letters ('a' to 'z') only.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        String S = "ababcbacadefegdehijhklij";

        List<Integer> result = new Solution().partitionLabels(S);

        System.out.println(1);
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();

        if (S == null || S.length() == 0) {
            return result;
        }

        int[] lastIndexes = new int[26];

        for (int i = 0; i < S.length(); i++) {

            lastIndexes[S.charAt(i) - 'a'] = i;
        }

        int startIndex = 0;
        int max = 0;
        for (int i = 0; i < S.length(); i++) {

            max = Math.max(max, lastIndexes[S.charAt(i) - 'a']);
            if (i == max) {
                result.add(i - startIndex + 1);
                startIndex = i + 1;
            }
        }

        return result;
    }
}