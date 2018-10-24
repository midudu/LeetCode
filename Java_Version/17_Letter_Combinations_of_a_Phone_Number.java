/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order,
your answer could be in any order you want.*/

import java.util.*;

// Complex Version
/* class MyTree {

    String value;

    ArrayList<MyTree> sons;

    MyTree(String value) {
        this.value = value;
        this.sons = new ArrayList<>();
    }
}


class Solution {

    HashMap<Character, String> hashMap = new HashMap<>();

    {
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        hashMap.put('0', " ");
        hashMap.put('1', "*");
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        MyTree root = new MyTree("");

        generateTree(digits, root);

        outputInListStringForm(root);

        return this.result;
    }

    private void generateTree(String digits, MyTree root) {

        Queue<MyTree> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 0; i < digits.length(); i++) {


            String possibleValues = this.hashMap.getOrDefault(digits.charAt(i), "");
            if (possibleValues.equals("")) {
                continue;
            }

            int size = queue.size();
            for (int j = 0; j < size; j++) {

                MyTree currentTree = queue.poll();

                for (int k = 0; k < possibleValues.length(); k++) {

                    MyTree sonTree
                            = new MyTree(String.valueOf(possibleValues.charAt(k)));

                    currentTree.sons.add(sonTree);

                    queue.offer(sonTree);
                }
            }
        }
    }


    private List<String> result = new ArrayList<>();

    private void outputInListStringForm(MyTree root) {

        for (int i = 0; i < root.sons.size(); i++) {
            outputInListStringFormHelper(root.sons.get(i), new StringBuilder());
        }
    }

    private void outputInListStringFormHelper(MyTree root, StringBuilder existingString) {

        existingString.append(root.value);

        if (root.sons.isEmpty()) {
            result.add(existingString.toString());
        } else {
            for (int i = 0; i < root.sons.size(); i++) {
                outputInListStringFormHelper(root.sons.get(i), existingString);
            }
        }

        existingString.deleteCharAt(existingString.length() - 1);
    }
} */

// Simple Version
class Solution {
	
	private List<String> result = new ArrayList<>();
	
	public List<String> letterCombinations(String digits) {
		
		if ( digits == null || digits.isEmpty() ) {
			return new ArrayList<>();
		}
		
		String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		letterCombinationsHelper(digits, 0, "", map);
		
		return this.result;
	}
	
	private void letterCombinationsHelper(
	    String digits, int currentIndex, String existingString, String[] map) {
		
		if ( currentIndex == digits.length() ) {
			
			this.result.add(existingString);
			
			return;
		}
		
		String possibleValues = map[digits.charAt(currentIndex) - '0'];
		for (int i = 0; i < possibleValues.length(); i++) {
			letterCombinationsHelper(digits, currentIndex+1, 
			existingString + possibleValues.charAt(i), map);
		}
	}
}

