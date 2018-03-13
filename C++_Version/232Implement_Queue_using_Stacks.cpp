//Implement the following operations of a queue using stacks.
//push(x) --Push element x to the back of queue.
//pop() --Removes the element from in front of queue.
//peek() --Get the front element.
//empty() --Return whether the queue is empty.
//Notes:
//You must use only standard operations of a stack -- which means only push to top, peek / pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively.You may simulate a stack by using a list or deque(double - ended queue), as long as you use only standard operations of a stack.
//You may assume that all operations are valid(for example, no pop or peek operations will be called on an empty queue).

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <unordered_map>
using namespace std;


class MyQueue {
public:
	/** Initialize your data structure here. */
	MyQueue() {
		stack<int> queue;
	}

	/** Push element x to the back of queue. */
	void push(int x) {
		push_helper(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	int pop() {
		int temp = queue.top();
		queue.pop();
		return temp;
	}

	/** Get the front element. */
	int peek() {
		return queue.top();
	}

	/** Returns whether the queue is empty. */
	bool empty() {
		return (queue.size() == 0);
	}

private:
	stack<int> queue;

	void push_helper(int x)
	{
		if (queue.size() == 0)
		{
			queue.push(x);
			return;
		}
		int temp = queue.top();
		queue.pop();
		push_helper(x);
		queue.push(temp);
	}
};

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
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