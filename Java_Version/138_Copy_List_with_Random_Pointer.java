/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

        Return a deep copy of the list.*/


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Solution {

    public static void main(String[] args) {

        RandomListNode head = new RandomListNode(-1);

        RandomListNode another = new Solution().copyRandomList(head);

        if (head == another) {
            System.out.println("haha");
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        // Step 0: Check input parameter
        if (head == null) {
            return null;
        }

        // Step 1: Deep Copy Another set of nodes
        RandomListNode tempNode = head;
        while (tempNode != null) {

            RandomListNode nextNode = tempNode.next;
            RandomListNode copyNode = new RandomListNode(tempNode.label);
            tempNode.next = copyNode;
            copyNode.next = nextNode;
            tempNode = nextNode;
        }

        // Step 2: Add random node to copy nodes
        tempNode = head;
        while (tempNode != null) {

            RandomListNode randomNode = tempNode.random;
            tempNode = tempNode.next;

            if (randomNode != null) {
                tempNode.random = randomNode.next;
            }

            tempNode = tempNode.next;
        }

        // Step 3: Delete inner part
        tempNode = head;
        RandomListNode result = head.next;

        while (tempNode != null) {

            RandomListNode nextNode = tempNode.next;
            RandomListNode nextNextNode = tempNode.next.next;

            tempNode.next = nextNextNode;
            if (nextNextNode != null) {
                nextNode.next = nextNextNode.next;
            }

            tempNode = tempNode.next;
        }

        return result;
    }
}
