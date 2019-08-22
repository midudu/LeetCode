/*
  Implement a trie with insert, search, and startsWith methods.

Example:

        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true

Note:
  You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Node {

    Node[] nextNodes;
    Boolean isWords;

    Node() {
        nextNodes = new Node[26];
        isWords = false;
    }
}

class Trie {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {

            if (currentNode.nextNodes[word.charAt(i) - 'a'] == null) {
                currentNode.nextNodes[word.charAt(i) - 'a'] = new Node();
            }

            currentNode = currentNode.nextNodes[word.charAt(i) - 'a'];
        }

        currentNode.isWords = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            if (currentNode.nextNodes[word.charAt(i) - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.nextNodes[word.charAt(i) - 'a'];
        }

        return currentNode.isWords;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        Node currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (currentNode.nextNodes[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.nextNodes[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}
