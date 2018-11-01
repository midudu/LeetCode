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

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // let prime numbers to make up of key
        int[] prime = {2, 3, 5, 7, 11, 13, 17,
                19, 23, 29, 31, 41, 43, 47, 53,
                59, 61, 67, 71, 73, 79, 83, 89,
                97, 101, 103};

        List<List<String>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String s : strs) {

            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }

            List<String> stringList;
            if (map.containsKey(key)) {
                stringList = result.get(map.get(key));
            } else {
                stringList = new ArrayList<>();
                result.add(stringList);
                map.put(key, result.size() - 1);
            }
            stringList.add(s);
        }
        return result;
    }
}


/*
Method 2: Convert String to char array and then sort it as key: secure but slow

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) {

            List<List<String>> result = new ArrayList<>();
            return result;
        }

        Map<String, List> ans = new HashMap<String, List>();

        for(String s : strs){

            char[] ca = s.toCharArray();

            Arrays.sort(ca);

            String key = String.valueOf(ca);

            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            //then add the String to this key's List
            ans.get(key).add(s);
        }
        //seems like the values() function will return a array of all the values
        //each value is a list
        //then ArrayList will transfer the array to a list
        //so it would be a list of the list<String>
        return new ArrayList(ans.values());
    }
}*/
