#include <iostream>
#include <cstdlib>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
	vector<int> temp({ 2,4,8,7,1,13,78,34 });

	if (binary_search(temp.begin(), temp.end(), 14))
		cout << "����" << endl;
	else 
		cout << "������" << endl;

	vector<int>::iterator iter = find(temp.begin(), temp.end(), 13);
	if (iter == temp.end())
		cout << "������" << endl;
	else
		cout << "����" << *iter << endl;


	system("pause");

	return 0;
}