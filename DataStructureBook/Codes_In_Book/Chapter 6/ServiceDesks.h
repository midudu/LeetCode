#ifndef SIMULATOR_H
#define SIMULATOR_H

#include <iostream>
#include <cstdlib>
#include <queue>
#include <vector>
#include <list>
#include <functional>
#include <ctime>
#include <random>

using namespace std;



class simulator
{
private:
	int noOfServer;             //服务台个数
	int arrivalLow;             //到达间隔时间的下界
	int arrivalHigh;            //到达间隔时间的上界
	int serviceTimeLow;         //服务间隔时间的下界
	int serviceTimeHigh;        //服务间隔时间的上界
	int customNum;              //模拟的顾客数

	struct eventT
	{
		int time;               //事件发生时间
		int type;               //事件类型：0为到达，1为离开
		bool operator>(const eventT& e) const  {  return time > e.time;   }
	};

public:
	simulator();
	void avgWaitTime();
};


#endif             //SIMULATOR_H
