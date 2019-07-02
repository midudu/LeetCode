/*
  Implement a MapSum class with insert, and sum methods.

  For the method insert, you'll be given a pair of (string, integer). The string
represents the key and the integer represents the value. If the key already
existed, then the original key-value pair will be overridden to the new one.

  For the method sum, you'll be given a string representing the prefix, and you
need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
        Input: insert("apple", 3), Output: Null
        Input: sum("ap"), Output: 3
        Input: insert("app", 2), Output: Null
        Input: sum("ap"), Output: 5
*/

import java.util.HashMap;

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

class TrieNode {

    int sum;
    TrieNode[] children = new TrieNode[26];
}

class MapSum {

    public static void main(String[] args) {

        MapSum map = new MapSum();

        map.insert("aa", 3);
        System.out.println(map.sum("a"));
        map.insert("aa", 2);
        System.out.println(map.sum("a"));
    }

    private TrieNode root;
    private HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {

        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {

        if (key == null || key.length() == 0) {
            return;
        }

        if (map.containsKey(key)) {
            int oldVal = map.get(key);
            int diff = val - oldVal;
            map.put(key, val);
            val = diff;
        } else {
            map.put(key, val);
        }

        TrieNode currentNode = this.root;
        for (int i = 0 ; i < key.length(); i++) {

            TrieNode nextNode = currentNode.children[key.charAt(i) - 'a'];
            if (nextNode == null) {
                nextNode = new TrieNode();
                currentNode.children[key.charAt(i) - 'a'] = nextNode;
            }
            nextNode.sum += val;
            currentNode = nextNode;
        }
    }

    public int sum(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            return 0;
        }

        TrieNode currentNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode nextNode = currentNode.children[prefix.charAt(i) - 'a'];
            if (nextNode == null) {
                return 0;
            }
            currentNode = nextNode;
        }

        return currentNode.sum;
    }
}

