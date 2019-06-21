/*
  Given a list of sorted characters letters containing only lowercase letters,
and given a target letter target, find the smallest element in the list that is
larger than the given target.

  Letters also wrap around. For example, if the target is target = 'z' and \
letters = ['a', 'b'], the answer is 'a'.

Examples:

        Input:
        letters = ["c", "f", "j"]
        target = "a"
        Output: "c"

        Input:
        letters = ["c", "f", "j"]
        target = "c"
        Output: "f"

        Input:
        letters = ["c", "f", "j"]
        target = "d"
        Output: "f"

        Input:
        letters = ["c", "f", "j"]
        target = "g"
        Output: "j"

        Input:
        letters = ["c", "f", "j"]
        target = "j"
        Output: "c"

        Input:
        letters = ["c", "f", "j"]
        target = "k"
        Output: "c"

Note:
        letters has a length in range [2, 10000].

        letters consists of lowercase letters, and contains at least 2 unique letters.

        target is a lowercase letter.
*/

class Solution {

    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};

        Solution solution = new Solution();

        System.out.println(solution.nextGreatestLetter(letters, 'a'));
        System.out.println(solution.nextGreatestLetter(letters, 'c'));
        System.out.println(solution.nextGreatestLetter(letters, 'd'));
        System.out.println(solution.nextGreatestLetter(letters, 'g'));
        System.out.println(solution.nextGreatestLetter(letters, 'j'));
        System.out.println(solution.nextGreatestLetter(letters, 'k'));
    }

    public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length < 2) {
            throw new RuntimeException("illegal input");
        }

        int startIndex = 0, endIndex = letters.length - 1;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (letters[middleIndex] <= target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex;
            }
        }

        return (letters[startIndex] > target ? letters[startIndex] : letters[0]);
    }
}
