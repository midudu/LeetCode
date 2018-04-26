/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

        You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

        Example 1:
        Input:
        ["Shogun", "Tapioca Express", "Burger King", "KFC"]
        ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
        Output: ["Shogun"]
        Explanation: The only restaurant they both like is "Shogun".
        Example 2:
        Input:
        ["Shogun", "Tapioca Express", "Burger King", "KFC"]
        ["KFC", "Shogun", "Burger King"]
        Output: ["Shogun"]
        Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
        Note:
        The length of both lists will be in the range of [1, 1000].
        The length of strings in both lists will be in the range of [1, 30].
        The index is starting from 0 to the list length minus 1.
        No duplicates in both lists.Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

        You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

        Example 1:
        Input:
        ["Shogun", "Tapioca Express", "Burger King", "KFC"]
        ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
        Output: ["Shogun"]
        Explanation: The only restaurant they both like is "Shogun".
        Example 2:
        Input:
        ["Shogun", "Tapioca Express", "Burger King", "KFC"]
        ["KFC", "Shogun", "Burger King"]
        Output: ["Shogun"]
        Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
        Note:
        The length of both lists will be in the range of [1, 1000].
        The length of strings in both lists will be in the range of [1, 30].
        The index is starting from 0 to the list length minus 1.
        No duplicates in both lists.
*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);

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
    public String[] findRestaurant(String[] list1, String[] list2) {

        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        int length = list1.length;
        for (int i = 0; i < length; i++) {
            hashMap.put(list1[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        length = list2.length;
        for (int i = 0; i < length; ) {

            if (hashMap.containsKey(list2[i])) {
                int currentIndex = i + hashMap.get(list2[i]);
                if (currentIndex < minIndex) {
                    minIndex = currentIndex;
                    result.clear();
                    result.add(list2[i]);
                } else if (currentIndex == minIndex) {
                    result.add(list2[i]);
                }
            }
            i++;
            if ( i > minIndex ) {
                break;
            }
        }

        String[] output = new String[result.size()];
        return result.toArray(output);
    }
}