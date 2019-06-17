/*
  Given a string array words, find the maximum value of
length(word[i]) * length(word[j]) where the two words do not share common
letters. You may assume that each word will contain only lower case letters.
If no such two words exist, return 0.

Example 1:

        Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
        Output: 16
        Explanation: The two words can be "abcw", "xtfn".

Example 2:

        Input: ["a","ab","abc","d","cd","bcd","abcd"]
        Output: 4
        Explanation: The two words can be "ab", "cd".

Example 3:

        Input: ["a","aa","aaa","aaaa"]
        Output: 0
        Explanation: No such pair of words.
*/


class Solution {

    public static void main(String[] args) {

        int result = new Solution().maxProduct(
                new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});

        System.out.println(result);
    }

    public int maxProduct(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }

        int[] bits = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            bits[i] = getBitsForm(words[i]);
        }

        int result = 0;

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (ifTwoWordsNotShareCommon(bits[i], bits[j])) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }

    private int getBitsForm(String word) {

        int result = 0;

        for (int i = 0; i < word.length(); i++) {

            int value = word.charAt(i) - 'a';

            result |= (1 << value);
        }

        return result;
    }

    private boolean ifTwoWordsNotShareCommon(int bits1, int bits2) {

        int result = (bits1 & bits2);

        return result == 0;
    }
}
