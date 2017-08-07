#include <iostream>
#include <queue>
using namespace std;


int main()
{
	priority_queue<int> temp;

	temp.push(5);
	temp.push(8);
	temp.push(5);
	temp.push(2);
	temp.push(2);

	while (!temp.empty())
	{
		cout << temp.top() << endl;
		temp.pop();
	}

	return 0;
}