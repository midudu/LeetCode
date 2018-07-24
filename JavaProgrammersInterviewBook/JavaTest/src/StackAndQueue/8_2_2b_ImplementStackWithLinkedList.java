package StackAndQueue;

class ImplementStackWithLinkedList<E> {
	
	private Node<E> peekNode;
	
	public ImplementStackWithLinkedList() {
		peekNode = null;
	}
	
	private class Node<E>{
	    E val;
	    Node<E> next;
	    Node(E val) {
	        this.val = val;
	        this.next = null;
        }
    }

	public void push(E val) {
		
		Node<E> newPeekNode = new Node<E>(val);
		newPeekNode.next = peekNode;
		peekNode = newPeekNode;
	}
	
	public E pop() {
		
		if ( peekNode == null ) {
			return null;
		} else {
			
			E val = peekNode.val;
			peekNode = peekNode.next;
			return val;
		}
	}
	
	public E peek() {
		
		if (peekNode == null) {
			return null;
		} else {
			return peekNode.val;
		}
	}

	
	public boolean isEmpty() {
		return peekNode == null;
	}

    public static void main(String[] args) {

        ImplementStackWithLinkedList<Integer> stack
                = new ImplementStackWithLinkedList<>();

        Integer result1 = stack.pop();
        Integer result2 = stack.peek();

        for (int i = 0; i < 9; i++ ) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}