#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <queue>
#include <vector>
#include <list>
#include <functional>
#include <ctime>
#include <random>
#include <cstdlib>

using namespace std;

int random(int low, int high)
{
	return (low + (high - low + 1)*rand() / (RAND_MAX));
}


int main()
{
	srand((unsigned int)time(NULL));


	//-------------------生成num个项------------------------//
	int num = 100;
	queue<float, list<float>> term;
	float randomNum;
	for (int i = 0; i < num; ++i)
	{
		randomNum = random(1, 100) / float(100);
		cout << randomNum << ' ';
		term.push(randomNum);
	}
	cout << endl;


	//-------------------生成初始的num个盒子----------------------//
	priority_queue<float, vector<float>, greater<float>> box;
	for (int i = 0; i < num; ++i)
	{
		box.push(1.0);
	}

	//--------------------计算----------------------------//
	float tempTerm, tempBox,tempRemain;
	vector<float> remainBox;
	int boxCount = 0;

	while (!term.empty())
	{
		tempTerm = term.front();                    //取出队列头的项
		term.pop();

		tempBox = box.top();                        
		box.pop();

		while (1)
		{
			if (tempTerm > tempBox)
			{
				remainBox.push_back(tempBox);

				tempBox = box.top();
				box.pop();
			}
			else
			{
				tempRemain = tempBox - tempTerm;

				if (tempRemain < 0.01)
				{
					boxCount++;
				}
				else
				{
					box.push(tempRemain);
				}
				
				while (!remainBox.empty())
				{
					box.push(remainBox.back());
					remainBox.pop_back();
				}

				break;
			}
		}
	}

	while (box.top() != 1.0)
	{
		boxCount++;
		box.pop();
	}

	cout << "一共需要" << boxCount << "个盒子" << endl;

	system("pause");
	return 0;
}
