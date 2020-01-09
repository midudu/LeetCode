/*
  Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
  What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:

  // Init a singly linked list [1,2,3].
  ListNode head = new ListNode(1);
  head.next = new ListNode(2);
  head.next.next = new ListNode(3);
  Solution solution = new Solution(head);

  // getRandom() should return either 1, 2, or 3 randomly. Each element should
  have equal probability of returning.
  solution.getRandom();*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// Method 1: extra space
/*class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);

        for (int i = 0; i < 10; i++) {
            System.out.println(solution.getRandom());
        }
    }

    private List<Integer> list;
    private Random random;

    *//**
 * @param head The linked list's head. Note that the head is guaranteed to
 * be not null, so it contains at least one node.
 *//*
    public Solution(ListNode head) {

        list = new ArrayList<>();
        random = new Random();

        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }
    }

    */

/**
 * Returns a random node's value.
 *//*
    public int getRandom() {

        return list.get(random.nextInt(list.size()));
    }
}*/

// Method 2: no-extra space
class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);

        for (int i = 0; i < 10; i++) {
            System.out.println(solution.getRandom());
        }
    }

    private ListNode head;
    private int listLength;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to
     *             be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {

        this.head = head;

        ListNode pointer = head;
        listLength = 0;

        while (pointer != null) {
            listLength++;
            pointer = pointer.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {

        int randomIndex = (int) (Math.random() * listLength);

        ListNode pointer = this.head;
        for (int i = 0; i < randomIndex; i++) {
            pointer = pointer.next;
        }

        return pointer.val;
    }
}
