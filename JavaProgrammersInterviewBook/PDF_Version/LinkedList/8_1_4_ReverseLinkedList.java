package LinkedList;

class ReverseLinkedList {

    public Node reverseNonRecursively(Node head) {

        Node slow = null;
        Node fast = head;

        while (fast != null) {

            Node next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }

        return slow;
    }

    public Node reverseRecursively(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        Node newHead = reverseRecursively(next);
        next.next = head;
        head.next = null;

        return newHead;
    }


    public static void main(String[] args) {

        Node headOne = new Node(1);
        Node temp = headOne;
        for (int i = 2; i < 2; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }

        Node headTwo = new Node(1);
        temp = headTwo;
        for (int i = 2; i < 2; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }

        Node resultOne = new ReverseLinkedList().reverseNonRecursively(headOne);
        Node resultTwo = new ReverseLinkedList().reverseRecursively(headTwo);

        return;
    }
}