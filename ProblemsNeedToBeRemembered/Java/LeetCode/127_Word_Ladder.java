/*Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord,
such that:

        Only one letter can be changed at a time.
        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
        Note:

        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
        You may assume no duplicates in the word list.
        You may assume beginWord and endWord are non-empty and are not the same.
        Example 1:

        Input:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        Output: 5

        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.
        Example 2:

        Input:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        Output: 0

        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    // This algorithm use bi-direction BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        /*There are two HashSets, and during recursion the beginSet and endSet
        will exchange their identity according to the their inner elements'
        numbers*/
        // A HashSet to store the words in starting searching direction
        Set<String> beginSet = new HashSet<>();
        // A HashSet to store the words in target searching direction
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        /*A HashSet to store all the words and if a word has been visited, it
        will be deleted*/
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        return search(beginSet, endSet, dict, 1);
    }

    private int search(
            Set<String> beginSet, Set<String> endSet, Set<String> dict,
            int existingWordNumbers) {

        /* If {@code beginSet} or {@code endSet} is empty, this means there is
         * no way between start node to end node. As a result, return 0
         */
        if (beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }

        existingWordNumbers++;

        // Remove all the nodes in {@code dict} which have been visited
        dict.removeAll(beginSet);

        // This HashSet will store the next layer nodes from the
        // {@code beginSet}
        Set<String> nextLayerSet = new HashSet<>();

        // Iterate {@code beginSet}
        for (String str : beginSet) {

            char[] chs = str.toCharArray();

            // Try to replace every char in the current word with a-z
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

        // For the next recursion process, the beginSet is gonna be a set with
        // less elements' number so as to improve the efficiency of iteration (
        // it takes O(n) to iterate but O(1) to check if an element is contained
        // in another HashSet ideally)
        return nextLayerSet.size() > endSet.size() ?
                search(endSet, nextLayerSet, dict, existingWordNumbers) :
                search(nextLayerSet, endSet, dict, existingWordNumbers);
    }
}