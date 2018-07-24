#include <iostream>
#include <cstdlib>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
	vector<int> temp({ 2,4,8,7,1,13,78,34 });

	if (binary_search(temp.begin(), temp.end(), 14))
		cout << "存在" << endl;
	else 
		cout << "不存在" << endl;

	vector<int>::iterator iter = find(temp.begin(), temp.end(), 13);
	if (iter == temp.end())
		cout << "不存在" << endl;
	else
		cout << "存在" << *iter << endl;


	system("pause");

	return 0;
}