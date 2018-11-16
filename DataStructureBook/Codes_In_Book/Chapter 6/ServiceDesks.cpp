#include "stdafx.h"
#include "simulator.h"


simulator::simulator()
{
	noOfServer = 4;
	arrivalLow = 0; 
	arrivalHigh = 2;

	serviceTimeLow = 2; 
	serviceTimeHigh = 7;

	customNum = 1000;

	srand((unsigned int)time(NULL));
}



void simulator::avgWaitTime()
{
	int serverBusy = 0;             //正在工作的服务台数量
	int currentTime;
	int totalWaitTime = 0;
	int totalServiceTime = 0;           //用户总等待时间


	                                      //用list组织queue的时候，waitQueue是成功的，但是用vector的时候就会失败？？
	queue<eventT, list<simulator::eventT>> waitQueue;                                //顾客等待队列
	priority_queue<eventT,vector<eventT>,greater<eventT>> eventQueue;                   //事件队列
	                            //为了可以让greater正常使用，需要重载运算符>

	eventT currentEvent;


	//生成初始的事件队列
	int i;
	currentEvent.time = 0;
	currentEvent.type = 0;
	for (i = 0; i < customNum; ++i)
	{
		currentEvent.time += arrivalLow + (arrivalHigh - arrivalLow + 1) * rand() / (RAND_MAX + 1);
		//currentEvent.time += 1;
		eventQueue.push(currentEvent);
	}

	//模拟过程
	while (!eventQueue.empty())
	{
		currentEvent = eventQueue.top();
		eventQueue.pop();

		currentTime = currentEvent.time;

		switch (currentEvent.type)
		{
		case 0:
		{
				  if (serverBusy != noOfServer)
				  {
					  ++serverBusy;

					  currentEvent.time += serviceTimeLow + (serviceTimeHigh - serviceTimeLow + 1) * rand() / (RAND_MAX + 1);
					  totalServiceTime += currentEvent.time - currentTime;
					  currentEvent.type = 1;

					  eventQueue.push(currentEvent);
				  }
				  else
					  waitQueue.push(currentEvent);

				  break;
		}
		case 1:
		{
				  if (!waitQueue.empty())
				  {
					  currentEvent = waitQueue.front();
					  waitQueue.pop();

					  totalWaitTime += currentTime - currentEvent.time;

					  currentEvent.time = currentTime + serviceTimeLow + (serviceTimeHigh - serviceTimeLow + 1) * rand() / (RAND_MAX + 1);
					  totalServiceTime += currentEvent.time - currentTime;
					  currentEvent.type = 1;

					  eventQueue.push(currentEvent);
				  }
				  else
					  serverBusy--;

				  break;
		}
		}
	}


	cout << "用户平均等待时间：" << float(totalWaitTime) / customNum << endl;
	cout << "服务台平均服务时间：" << float(totalServiceTime) / noOfServer << endl;
	
}
