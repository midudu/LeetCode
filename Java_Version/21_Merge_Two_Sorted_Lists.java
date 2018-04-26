/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

        Example:

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        List<List<Integer>> receive = solution.fourSum(nums, 4);


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

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode psudoHead = new ListNode(0);
        ListNode tempNode = psudoHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tempNode.next = l1;
                tempNode = tempNode.next;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                tempNode = tempNode.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            tempNode.next = l1;
        } else if (l2 != null) {
            tempNode.next = l2;
        }

        return psudoHead.next;
    }
}