//过江渡船平均等待时间的模拟

#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <queue>
#include <stack>
#include <list>
using namespace std;

int random(int low, int high)      //生成[low,high]之间的随机数
{
	return (low + (high - low + 1)*rand() / (RAND_MAX + 1));
}


int main()
{
	srand((unsigned int)time(NULL));

	int coachNumber = 800;      //要模拟的客车总数量
	int trunkNumber = 400;      //要模拟的货车总数量

	queue<int, list<int>> coach;     //客车到达时间的队列
	queue<int, list<int>> trunk;     //货车到达时间的队列

	cout << "客车到达时间：\r\n";
	int tempTime = 0;
	for (int i = 0; i < coachNumber; ++i)     //随机生成客车到达时间
	{
		tempTime += random(1, 3);
		cout << tempTime << ' ';
		coach.push(tempTime);
	}
	cout << endl;

	cout << "货车到达时间：\r\n";
	tempTime = 0;
	for (int i = 0; i < trunkNumber; ++i)     //随机生成货车到达时间
	{
		tempTime += random(3, 8);
		cout << tempTime << ' ';
		trunk.push(tempTime);
	}
	cout << endl;


	int currentTime = random(0, 10);
	cout << "第一班轮渡到达时间：" << currentTime << endl;
	int coachCount = 0,maxTrunkCount,trunkCount = 0;
	int coachWaitTime = 0,trunkWaitTime = 0;

	int temp;

	while (1)
	{
		while (coachCount < 8 && !coach.empty())                                    //每来一辆过江渡船时，先尽可能地让8辆已经等候的客车先上船
		{
			if (coach.front() <= currentTime)
			{
				temp = currentTime - coach.front();
				coachWaitTime += temp;
				coachCount++;
				coach.pop();
			}
			else
			{
				break;
			}
		}
		maxTrunkCount = 10 - coachCount;

		while (trunkCount < maxTrunkCount && !trunk.empty())
		{
			if (trunk.front() <= currentTime)
			{
				temp = currentTime - trunk.front();
				trunkWaitTime += temp;
				trunkCount++;
				trunk.pop();
			}
			else
			{
				break;
			}
		}

		if (coach.empty() && trunk.empty())
			break;
		else
		{
			coachCount = 0;
			trunkCount = 0;
			currentTime += 10;
		}
	}
	cout << "所有车都被运走的时间：" << currentTime << endl;

	cout << "客车平均等待时间：" << float(coachWaitTime) / float(coachNumber) << endl;
	cout << "货车平均等待时间：" << float(trunkWaitTime) / float(trunkNumber) << endl;
		
	system("pause");
	return 0;
}
