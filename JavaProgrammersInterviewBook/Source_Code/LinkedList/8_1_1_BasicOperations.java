package LinkedList;

class Node {

    Node next;
    int val;

    public Node(int val) {

        this.val = val;
        this.next = null;
    }

    public Node() {
    }
}


class BasicOperationsOfNode {

    Node head;

    public BasicOperationsOfNode(Node headNode) {
        this.head = headNode;
    }

    public BasicOperationsOfNode() {

    }

    //在末尾添加节点
    public void addNodeToTail(int val) {

        if (head == null) {
            head = new Node(val);

        } else {

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
    }


    //删除第index个节点
    public boolean deleteNodeOfIndex(int index) {

        Node slow = null;
        Node fast = head;
        int indexCount = 0;

        while (fast != null) {
            if (indexCount == index) {
                if (fast == head) {
                    head = head.next;
                } else {
                    slow.next = fast.next;
                }
                return true;
            }
            indexCount++;
            slow = fast;
            fast = fast.next;
        }

        return false;
    }


    //返回链表的长度
    public int lengthOfLinkedList() {

        int length = 0;
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }


    //对链表进行排序(升序)
    public void orderLinkedList() {

        // 冒泡排序法
        Node outerNode = head;
        Node innerNode;

        while ( outerNode != null ) {

            innerNode = outerNode.next;
            while ( innerNode != null ) {

                if ( outerNode.val > innerNode.val ) {
                    int temp = outerNode.val;
                    outerNode.val = innerNode.val;
                    innerNode.val = temp;
                }
                innerNode = innerNode.next;
            }
            outerNode = outerNode.next;
        }

     }


    public static void main(String[] args) {

        Node headNode = new Node(7);
        BasicOperationsOfNode basicOperationsOfNode = new BasicOperationsOfNode(headNode);
        headNode.next = new Node(2);
        headNode.next.next = new Node(3);
        headNode.next.next.next = new Node(1);

        /*BasicOperationsOfNode basicOperationsOfNode1 = new BasicOperationsOfNode();
        basicOperationsOfNode1.orderLinkedList();

        BasicOperationsOfNode basicOperationsOfNode2 = new BasicOperationsOfNode(headNode);
        basicOperationsOfNode2.orderLinkedList();*/

        //测试在末尾添加节点
        basicOperationsOfNode.addNodeToTail(6);

        int length = basicOperationsOfNode.lengthOfLinkedList();
        basicOperationsOfNode.orderLinkedList();

        System.out.println("haha");
    }
}