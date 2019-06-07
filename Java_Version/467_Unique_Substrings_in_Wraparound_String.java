/*
  Consider the string s to be the infinite wraparound string of 
"abcdefghijklmnopqrstuvwxyz", so s will look like this: 
"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

  Now we have another string p. Your job is to find out how many unique 
non-empty substrings of p are present in s. In particular, your input is the 
string p and you need to output the number of different non-empty substrings of
p in the string s.

  Note: p consists of only lowercase English letters and the size of p might be 
over 10000.

Example 1:
    Input: "a"
    Output: 1

    Explanation: Only the substring "a" of string "a" is in the string s.

Example 2:
    Input: "cac"
    Output: 2

    Explanation: There are two substrings "a", "c" of string "cac" in the 
    string s.

Example 3:
    Input: "zab"
    Output: 6

    Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of 
    string "zab" in the string s.
*/

class Tuple {

    int startIndex, endIndex;

    public Tuple(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

class MyComparator implements Comparator<Tuple> {

    public int compare(Tuple t1, Tuple t2) {

        if (t1.startIndex != t2.endIndex) {
            return Integer.compare(t1.startIndex, t2.startIndex);
        }

        return Integer.compare(t1.endIndex, t2.endIndex);
    }
}

class Solution {

    public int findSubstringInWraproundString(String p) {

        if (p == null || p.length() == 0) {
            return 0;
        }    

        Set<Tuple> tupleSet = new TreeSet<Tuple>();

        int startIndex = 0;

        for (int i = 1; i < p.length(); p++) {

            if (p.chatAt(i) - p.chatAt(i-1) == 1 || 
                  (p.chatAt(i) == 'a' && p.chatAt(i-1) == 'z')) {
                continue;
            }

            Tuple tuple = new Tuple(p.chatAt(startIndex) - 'a', p.chatAt(startIndex) - 'a' + i - startIndex);
            tupleSet.add(tuple);

            startIndex = i;
        }

        tupleSet.add(new Tuple(p.chatAt(startIndex) - 'a', p.chatAt(startIndex) - 'a' + p.length() - startIndex));

        int result = 0;

        int start = tupleSet.first().startIndex, end = tupleSet.first().endIndex;

        for (Tuple tuple : tupleSet) {

            if (tuple.startIndex > end) {

                result += (end - start) / 2 * (end - start + 1);
                start = tuple.startIndex;
                end = tuple.endIndex;
            } else {
                end = Math.max(end, tuple.endIndex);
            }
        }

        result += (end - start) / 2 * (end - start + 1);

        return result;
    }
}
