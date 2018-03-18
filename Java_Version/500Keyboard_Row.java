/*Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


        American keyboard


        Example 1:
        Input: ["Hello", "Alaska", "Dad", "Peace"]
        Output: ["Alaska", "Dad"]
        Note:
        You may use one character in the keyboard more than once.
        You may assume the input string will only contain letters of alphabet.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        int a = 3, b = 0;


        int result = a / b;


        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private ArrayList<Integer> resultIndex;
    private HashMap<Character, Integer> keyboardTable = new HashMap<>();

    public String[] findWords(String[] words) {

        int wordsLength = words.length;

        resultIndex = new ArrayList<Integer>(wordsLength);
        initKeyboardTable();

        for (int i = 0; i < wordsLength; i++) {
            boolean flag = processString(words[i]);
            if (flag) {
                resultIndex.add(i);
            }
        }

        String[] result = new String[resultIndex.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = words[resultIndex.get(i)];
        }

        return result;
    }

    private boolean processString(String word) {
        int value = keyboardTable.get(word.charAt(0));

        int wordLength = word.length();
        for ( int i = 1; i < wordLength; i++ ){
            if ( keyboardTable.get(word.charAt(i)) != value ){
                return false;
            }
        }

        return true;
    }

    private void initKeyboardTable() {
        keyboardTable.put('Q',1);
        keyboardTable.put('W',1);
        keyboardTable.put('E',1);
        keyboardTable.put('R',1);
        keyboardTable.put('T',1);
        keyboardTable.put('Y',1);
        keyboardTable.put('U',1);
        keyboardTable.put('I',1);
        keyboardTable.put('O',1);
        keyboardTable.put('P',1);
        keyboardTable.put('q',1);
        keyboardTable.put('w',1);
        keyboardTable.put('e',1);
        keyboardTable.put('r',1);
        keyboardTable.put('t',1);
        keyboardTable.put('y',1);
        keyboardTable.put('u',1);
        keyboardTable.put('i',1);
        keyboardTable.put('o',1);
        keyboardTable.put('p',1);

        keyboardTable.put('A',2);
        keyboardTable.put('S',2);
        keyboardTable.put('D',2);
        keyboardTable.put('F',2);
        keyboardTable.put('G',2);
        keyboardTable.put('H',2);
        keyboardTable.put('J',2);
        keyboardTable.put('K',2);
        keyboardTable.put('L',2);
        keyboardTable.put('a',2);
        keyboardTable.put('s',2);
        keyboardTable.put('d',2);
        keyboardTable.put('f',2);
        keyboardTable.put('g',2);
        keyboardTable.put('h',2);
        keyboardTable.put('j',2);
        keyboardTable.put('k',2);
        keyboardTable.put('l',2);

        keyboardTable.put('Z',3);
        keyboardTable.put('X',3);
        keyboardTable.put('C',3);
        keyboardTable.put('V',3);
        keyboardTable.put('B',3);
        keyboardTable.put('N',3);
        keyboardTable.put('M',3);
        keyboardTable.put('z',3);
        keyboardTable.put('x',3);
        keyboardTable.put('c',3);
        keyboardTable.put('v',3);
        keyboardTable.put('b',3);
        keyboardTable.put('n',3);
        keyboardTable.put('m',3);
    }
}