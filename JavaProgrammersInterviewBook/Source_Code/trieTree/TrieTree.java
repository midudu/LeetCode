package trieTree;

import java.util.Arrays;
import java.util.HashSet;

// This Trie-tree only contains lower a to z
class TrieNode {

    // to store the strings of the current layer
    HashSet<String> stringSet;

    // to store the next layer node
    TrieNode[] nextNodes;

    TrieNode() {

        this.nextNodes = new TrieNode[26];
        this.stringSet = new HashSet<>();
    }
}


class TrieTree {

    private TrieNode rootNode = new TrieNode();

    public void insertString(String s) {

        if (s == null || s.isEmpty()) {
            return;
        }

        s = s.toLowerCase();

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);


        TrieNode tempNode = this.rootNode;
        for (int i = 0; i < sArray.length; i++) {

            if (tempNode.nextNodes[sArray[i] - 'a'] == null) {
                tempNode.nextNodes[sArray[i] - 'a'] = new TrieNode();
            }
            tempNode = tempNode.nextNodes[sArray[i] - 'a'];

            if (i == sArray.length - 1) {
                tempNode.stringSet.add(s);
            }
        }
    }

    public boolean searchString(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.toLowerCase();
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        TrieNode tempNode = this.rootNode;

        for (int i = 0; i < sArray.length; i++) {
            if (tempNode.nextNodes[sArray[i] - 'a'] == null) {
                return false;
            }
            tempNode = tempNode.nextNodes[sArray[i] - 'a'];
        }

        return tempNode.stringSet.contains(s);
    }

    public static void main(String[] args) {


    }
}

class TestTrieTree {

    public static void main(String[] args) {

        TrieTree trieTree = new TrieTree();

        trieTree.insertString("hehao");
        trieTree.insertString("ehaoh");
        trieTree.insertString("haohe");
        trieTree.insertString("aoheh");
        trieTree.insertString("facri");
        trieTree.insertString("et");
        trieTree.insertString("oheha");

        boolean result;

        result = trieTree.searchString("hehao");
        result = trieTree.searchString("et");
        result = trieTree.searchString("asglajs");
        result = trieTree.searchString("oaehh");

        System.out.println(result);
    }
}