/* Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space? */


class Solution {
    public boolean backspaceCompare(String S, String T) {

        char[] SCharArray = S.toCharArray();
        char[] TCharArray = T.toCharArray();

        int SPointer = 0;
        int TPointer = 0;

        for (int i = 0; i < SCharArray.length; i++) {

            if (SCharArray[i] == '#') {
                if (SPointer > 0) {
                    SPointer--;
                }
            } else {
                SCharArray[SPointer] = SCharArray[i];
                SPointer++;
            }
        }

        for (int i = 0; i < TCharArray.length; i++) {

            if (TCharArray[i] == '#') {
                if (TPointer > 0) {
                    TPointer--;
                }
            } else {
                TCharArray[TPointer] = TCharArray[i];
                TPointer++;
            }
        }

        if (SPointer != TPointer) {
            return false;
        }

        for (int i = 0; i < SPointer; i++) {
            if (SCharArray[i] != TCharArray[i]) {
                return false;
            }
        }

        return true;
    }
}