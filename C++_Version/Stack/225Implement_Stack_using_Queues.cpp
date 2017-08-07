//Implement the following operations of a stack using queues.
//
//push(x) --Push element x onto stack.
//pop() --Removes the element on top of the stack.
//top() --Get the top element.
//empty() --Return whether the stack is empty.
//Notes:
//You must use only standard operations of a queue -- which means only push to back, peek / pop from front, size, and is empty operations are valid.
//Depending on your language, queue may not be supported natively.You may simulate a queue by using a list or deque(double - ended queue), as long as you use only standard operations of a queue.
//You may assume that all operations are valid(for example, no pop or top operations will be called on an empty stack).

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


class MyStack {
public:
	/** Initialize your data structure here. */
	MyStack() {
		queue<int> stack;
	}

	/** Push element x onto stack. */
	void push(int x) {
		stack.push(x);

		int size = stack.size();

		for (int i = 0; i < size - 1; ++i)
		{
			int temp = stack.front();
			stack.pop();
			stack.push(temp);
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	int pop() {
		int temp = stack.front();
		stack.pop();
		return temp;
	}

	/** Get the top element. */
	int top() {
		return stack.front();
	}

	/** Returns whether the stack is empty. */
	bool empty() {
		return (stack.size() == 0);
	}

private:
	queue<int> stack;
};

/**
* Your MyStack object will be instantiated and called as such:
* MyStack obj = new MyStack();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.top();
* bool param_4 = obj.empty();
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