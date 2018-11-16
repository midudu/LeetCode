//Ackerman函数，递归和非递归（栈）实现


#include "stdafx.h"

#include <iostream>
#include <cstdlib>
#include <stack>
#include <list>

using namespace std;


int AckermannRecursion(int m, int n)
{

	cout << "m= " << m << " n= " << n << endl;
	if (m == 0)
	{
		return(n + 1);
	}

	if (m > 0 && n == 0)
	{
		return(AckermannRecursion(m - 1, 1));
	}

	if (m > 0 && n > 0)
	{
		return(AckermannRecursion(m - 1, AckermannRecursion(m, n - 1)));
	}
}

int AckermannNonRecursion(int m, int n)
{
	stack<int,list<int>> listM;
	listM.push(m);

	while (!listM.empty())
	{
		m = listM.top();
		listM.pop();

		if (!m)
		{
			n = n + 1;
		}
		else if (!n)
		{
			m = m - 1;
			n = 1;
			listM.push(m);
		}
		else
		{
			n = n - 1;
			listM.push(m - 1);
			listM.push(m);
		}
	}
	return n;
}

int main()
{
	int result1;
	result1 = AckermannRecursion(3, 0);
	cout << "AckermannRecursion(3,0) = " << result1 << endl;

	int result2;
	result2 = AckermannNonRecursion(3, 0);
	cout << "AckermannNonRecursion(3,0) = " << result2 << endl;

	system("pause");
	return 0;
}
