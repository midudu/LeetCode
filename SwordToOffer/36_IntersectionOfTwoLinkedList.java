/* 输入两个链表，找出它们的第一个公共结点。 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

    int length1 = 0;
    int length2 = 0;

    ListNode temp = pHead1;
    while (temp != null) {
      length1++;
      temp = temp.next;
    }

    temp = pHead2;
    while (temp != null) {
      length2++;
      temp = temp.next;
    }

    if (length1 <= length2) {
      return FindFirstCommonNodeHelper(pHead1, pHead2, length1, length2);
    } else {
      return FindFirstCommonNodeHelper(pHead2, pHead1, length2, length1);
    }
  }

  private ListNode FindFirstCommonNodeHelper(ListNode pHead1, ListNode pHead2,
    int length1, int length2) {

    int delta_length = length2 - length1;

    ListNode temp = pHead2;
    for (int i = 0; i < delta_length; i++) {
      temp = temp.next;
    }

    while (pHead1 != null) {

      if (pHead1 == temp) {
        return pHead1;
      }
      pHead1 = pHead1.next;
      temp = temp.next;
    }

    return null;
  }
}