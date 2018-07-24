package trieTree;

/* Trie树的构建、查找 */

import java.util.Arrays;
import java.util.HashSet;

class TrieTree {

    private class TrieNode {

        HashSet<String> stringSet;
        TrieNode[] nextNodes;

        TrieNode() {
            nextNodes = new TrieNode[26];    //只包括小写的a-z
        }
    }

    private TrieNode rootNode;

    public void insertString(String s) {

        if (s == null || s.length() == 0) {
            return;
        }

        s = s.toLowerCase();

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        if (rootNode == null) {
            rootNode = new TrieNode();
        }

        TrieNode tempNode = rootNode;
        for (int i = 0; i < sArray.length; i++) {
            if (tempNode.nextNodes[sArray[i] - 'a'] == null) {
                tempNode.nextNodes[sArray[i] - 'a'] = new TrieNode();
            }
            tempNode = tempNode.nextNodes[sArray[i] - 'a'];

            if (i == sArray.length - 1) {
                if (tempNode.stringSet == null) {
                    tempNode.stringSet = new HashSet<>();
                }
                tempNode.stringSet.add(s);
            }
        }
    }

    public boolean searchString(String s) {
		
		if ( s == null || s.length() == 0 ) {
			return rootNode == null;
		}
		
		if ( rootNode == null ) {
			return false;
		}
		
		s = s.toLowerCase();
		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);
		TrieNode tempNode = rootNode;
		
		for ( int i = 0; i < sArray.length; i++ ) {
			if (tempNode.nextNodes[sArray[i] - 'a'] == null) {
				return false;
			}
			tempNode = tempNode.nextNodes[sArray[i] - 'a'];
		}
		
		return tempNode.stringSet != null && tempNode.stringSet.contains(s);
    }

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

        System.out.println("haha");
    }
}