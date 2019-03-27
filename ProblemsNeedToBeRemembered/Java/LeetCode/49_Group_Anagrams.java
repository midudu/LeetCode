/*
Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
        Note:

        All inputs will be in lowercase.
        The order of your output does not matter.*/

import java.util.*;


// Method 1: Prime numbers: fast but might have maximum values limitation?
/*class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // let prime numbers to make up of key(26 keys which represent 26 alphabets)
        int[] primeKeys = {2, 3, 5, 7, 11, 13, 17,
                19, 23, 29, 31, 41, 43, 47, 53,
                59, 61, 67, 71, 73, 79, 83, 89,
                97, 101, 103};

        List<List<String>> result = new ArrayList<>();

        // Value represents the index in result
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (String string : strs) {

            int currentKey = 1;
            for (char c : string.toCharArray()) {
                currentKey *= primeKeys[c - 'a'];
            }

            List<String> currentStringList;
            if (hashMap.containsKey(currentKey)) {
                currentStringList = result.get(hashMap.get(currentKey));
            } else {
                currentStringList = new ArrayList<>();
                result.add(currentStringList);
                hashMap.put(currentKey, result.size() - 1);
            }

            currentStringList.add(string);
        }

        return result;
    }
}*/


// Method 2: Convert String to char array and then sort it as key: secure but slow

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        List<List<String>> result = new ArrayList<>(strs.length);

        for (String s : strs) {

            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String currentKey = String.valueOf(ca);

            List<String> currentStringList;

            if (!map.containsKey(currentKey)) {
                currentStringList = new ArrayList<>();
                result.add(currentStringList);
                map.put(currentKey, result.size() - 1);
            } else {
                currentStringList = result.get(map.get(currentKey));
            }

            currentStringList.add(s);
        }

        return result;
    }
}
