/*
Design a data structure that supports the following two operations:

        void addWord(word)
        bool search(word)

search(word) can search a literal word or a regular expression string
containing only letters a-z or .. A
. means it can represent any one letter.

        Example:

        addWord("bad")
        addWord("dad")
        addWord("mad")
        search("pad") -> false
        search("bad") -> true
        search(".ad") -> true
        search("b..") -> true

        Note:
        You may assume that all words are consist of lowercase letters a-z.*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class Node {

    boolean isWord;
    Node[] nextNodes;

    Node() {

        isWord = false;
        nextNodes = new Node[26];
    }
}

class WordDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

        if (word == null || word.isEmpty()) {
            return;
        }

        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);

            if (currentNode.nextNodes[currentChar - 'a'] == null) {
                currentNode.nextNodes[currentChar - 'a'] = new Node();
            }

            currentNode = currentNode.nextNodes[currentChar - 'a'];
        }

        currentNode.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        if (word == null || word.isEmpty()) {
            return true;
        }

        if (word.charAt(0) == '.') {

            for (int i = 0; i < root.nextNodes.length; i++) {
                if (searchHelper(root.nextNodes[i], word, 0)) {
                    return true;
                }
            }

            return false;

        } else {

            return searchHelper(root.nextNodes[word.charAt(0) - 'a'],
                    word, 0);
        }
    }

    private boolean searchHelper(
            Node currentNode, String word, int currentIndex) {

        if (currentNode == null) {
            return false;
        }

        if (currentIndex == word.length() - 1) {
            return currentNode.isWord;
        }

        char nextChar = word.charAt(currentIndex + 1);
        if (nextChar == '.') {
            for (int i = 0; i < currentNode.nextNodes.length; i++) {
                if (searchHelper(currentNode.nextNodes[i],
                        word, currentIndex + 1)) {
                    return true;
                }
            }

            return false;

        } else {

            return searchHelper(currentNode.nextNodes[nextChar - 'a'],
                    word, currentIndex + 1);
        }
    }
}

