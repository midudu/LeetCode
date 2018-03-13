//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) --Push element x onto stack.
//pop() --Removes the element on top of the stack.
//top() --Get the top element.
//getMin() --Retrieve the minimum element in the stack.
//Example:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns - 3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns - 2.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
using namespace std;


class MinStack {
public:
	/** initialize your data structure here. */
	MinStack() {
		stack<int> min_stack_;
		stack<int> store_stack_;
	}

	void push(int x) {
		if (min_stack_.empty())
			min_stack_.push(x);
		else if (x <= min_stack_.top())
			min_stack_.push(x);

		store_stack_.push(x);
	}

	void pop() {
		if (store_stack_.top() == min_stack_.top())
			min_stack_.pop();

		store_stack_.pop();
	}

	int top() {
		return store_stack_.top();
	}

	int getMin() {
		return min_stack_.top();
	}

private:
	stack<int> min_stack_;
	stack<int> store_stack_;
};

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/

int main()
{
	MyQueue queue;

	queue.push(1);
	queue.push(2);
	queue.push(3);

	cout << queue.peek() << endl;
	cout << queue.pop() << endl;
	cout << queue.pop() << endl;
	cout << queue.empty() << endl;

	system("pause");

	return 0;
}