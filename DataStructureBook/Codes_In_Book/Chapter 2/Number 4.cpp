//约瑟夫环问题，一次list的使用尝试

#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <list>
using namespace std;

int JosephProblem(int n);


int main() 
{
	int receiveNum = 0;

	for (int i = 2; i < 21; ++i)
	{
		receiveNum = JosephProblem(i);
		cout << i << " persons play Joseph Game, the Number " << receiveNum << " guy is the winner!\r\n";
	}

	system("pause");

	return 0;
}



int JosephProblem(int n)
{
	if (n <= 1)
		return -1;
	else
	{
		list<int> queue;               

		for (int i = 1; i <= n; ++i)
		{
			queue.push_back(i);
		}

		list<int>::const_iterator itr = queue.begin();
		char number = 0;

		while (1)
		{
			++number;
			if (number == 3)
			{
				number = 0;
				itr = queue.erase(itr);
			}
			else
				++itr;

			if (itr == queue.end())
				itr = queue.begin();

			if (queue.size() == 1)
				break;
		}

		return (*itr);
	}
}
