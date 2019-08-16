/*
  Given two words (beginWord and endWord), and a dictionary's word list, find
the length of shortest transformation sequence from beginWord to endWord, such
that:
  1. Only one letter can be changed at a time.
  2. Each transformed word must exist in the word list. Note that beginWord is
  not a transformed word.

Note:
  1. Return 0 if there is no such transformation sequence.
  2. All words have the same length.
  3. All words contain only lowercase alphabetic characters.
  4. You may assume no duplicates in the word list.
  5. You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

        Input:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        Output: 5

        Explanation: As one shortest transformation is
          "hit" -> "hot" -> "dot" -> "dog" -> "cog",
          return its length 5.

Example 2:

        Input:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        Output: 0

        Explanation: The endWord "cog" is not in wordList, therefore no
          possible transformation.
*/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return search(beginSet, endSet, dict, 1);
    }

    private int search(
            Set<String> beginSet, Set<String> endSet, Set<String> dict,
            int existingWordNumbers) {

        if (beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }

        existingWordNumbers++;
        dict.removeAll(beginSet);

        Set<String> nextLayerSet = new HashSet<>();

        for (String str : beginSet) {

            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];

                for (char j = 'a'; j <= 'z'; j++) {

                    chs[i] = j;
                    String tmp = new String(chs);

                    if (!dict.contains(tmp)) {
                        continue;
                    }

                    if (endSet.contains(tmp)) {
                        return existingWordNumbers;
                    }

                    nextLayerSet.add(tmp);
                }

                chs[i] = c;
            }
        }

        return nextLayerSet.size() > endSet.size() ?
                search(endSet, nextLayerSet, dict, existingWordNumbers) :
                search(nextLayerSet, endSet, dict, existingWordNumbers);
    }
}
