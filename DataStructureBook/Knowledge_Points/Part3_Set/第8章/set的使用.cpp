#include <iostream>
#include <cstdlib>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
	set<int> temp;

	vector<int> a({ 7,9,10,2,5,3,4,7,6,1 });


	//insert操作
	for (int i = 0; i < a.size(); ++i)
	{
		pair<set<int>::iterator, bool> receive = temp.insert(a[i]);

		if (!receive.second)
			cout << a[i] << "insertion failed" << endl;
		else
			cout << a[i] << "insertion succeeded" << endl;
	}
		
	cout << endl;

	//正序遍历
	for (set<int>::iterator iter = temp.begin(); iter != temp.end(); iter++)
		cout << *iter << endl;

	cout << endl;

	//倒序遍历
	for (set<int>::reverse_iterator riter = temp.rbegin(); riter != temp.rend(); riter++)
		cout << *riter << endl;

	//查找
	if ( temp.find(4) != temp.end() )
		cout << "find 4" << endl;
	
	

	//删除
	temp.erase(temp.begin());

	temp.erase(5);

	set<int>::iterator iter2 = temp.begin();
	std::advance(iter2, 4);                //set的iterator每次只能移动一步，使用advance函数移动多步

	temp.erase(temp.begin(), iter2);


	system("pause");

	return 0;
}