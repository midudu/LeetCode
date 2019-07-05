/*
  Implement a MapSum class with insert, and sum methods.

  For the method insert, you'll be given a pair of (string, integer). The
string represents the key and the integer represents the value. If the key
already existed, then the original key-value pair will be overridden to the new
one.

  For the method sum, you'll be given a string representing the prefix, and you
need to return the sum of all the pairs' value whose key starts with the prefix.

  Example 1:

        Input: insert("apple", 3), Output: Null
        Input: sum("ap"), Output: 3
        Input: insert("app", 2), Output: Null
        Input: sum("ap"), Output: 5
*/

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

class Node {

    Node[] children = new Node[26];
    int value;
    String string;
}


class MapSum {

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();

        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));

        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public MapSum() {
    }

    public void insert(String key, int val) {

        if (key == null || key.length() == 0) {
            return;
        }

        Node currentNode = this.root;

        for (int i = 0; i < key.length(); i++) {

            char currentChar = key.charAt(i);

            if (currentNode.children[currentChar - 'a'] == null) {
                currentNode.children[currentChar - 'a'] = new Node();
            }

            currentNode = currentNode.children[currentChar - 'a'];
            currentNode
        }

        currentNode.string = key;
        currentNode.value = val;
    }

    public int sum(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            return 0;
        }

        int result = 0;
        Node currentNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {

            Node nextNode = currentNode.children[prefix.charAt(i) - 'a'];
            if (nextNode == null) {
                break;
            }
            result += nextNode.value;

            currentNode = nextNode;
        }

        return result;
    }
}


