/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,

for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify
repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule.

Example:

        Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

        Output: ["AAAAACCCCC", "CCCCCAAAAA"]*/

import java.util.*;

/* Method 1: HashSet of SubString: easy but slow

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        Set<String> result = new HashSet<>();

        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String currentString = s.substring(i, i+ 10);

            if (set.contains(currentString)) {
                result.add(currentString);
            } else {
                set.add(currentString);
            }
        }

        return new ArrayList<>(result);
    }
}*/

// Method 2: HashSet and bit-manipulation and sliding-window: hard to think of but quick

class Solution {

    public static void main(String[] args) {

        new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        Set<Integer> subStringSet = new HashSet<>();
        Set<Integer> uniqueSequence = new HashSet<>();
        List<String> result = new ArrayList<>();

        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        int value = 0;
        for (int i = 0; i < 9; i++) {

            // extract the corresponding code of the current char
            int currentCorrespondingCode = map[s.charAt(i) - 'A'];

            // add the current code to the least 2 bits
            value <<= 2;
            value |= currentCorrespondingCode;

            // abandon high bits because only the least 10 * 2 = 20 bits are
            // what we focus on
            value &= 0xfffff;
        }

        for (int i = 9; i < s.length(); i++) {

            int currentCorrespondingCode = map[s.charAt(i) - 'A'];

            value <<= 2;
            value |= currentCorrespondingCode;
            value &= 0xfffff;

            if (!subStringSet.add(value) &&  uniqueSequence.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }

        return result;
    }
}