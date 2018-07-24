#include <iostream>
#include <cstdlib>
#include <map>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;


int main()
{
	vector<int>    a({ 7,     9,     10,    2,     5,     3,     4,     7,      6,      1});
	vector<string> b({"��һ","Ǯ��","����","����","����","����","֣��","����","���", "��ʮ"});

	map<int, string> temp;

	//insert����
	for (int i = 0; i < (int)a.size(); ++i)
		temp[a[i]] = b[i];


	//�������
	map<int, string>::iterator iter1;
	for (iter1 = temp.begin(); iter1 != temp.end(); iter1++)
		cout << iter1->first << ' ' << iter1->second << endl;

	cout << endl;

	//�������
	map<int, string>::reverse_iterator iter2;
	for (iter2 = temp.rbegin(); iter2 != temp.rend(); iter2++)
		cout << iter2->first << ' ' << iter2->second << endl;

	cout << endl;
	
	//����
	iter1 = temp.find(4);
	if (iter1 != temp.end())
		cout << "find 4";

	//ɾ��
	temp.erase(temp.begin());

	temp.erase(5);

	iter1 = temp.begin();
	std::advance(iter1, 4);                //set��iteratorÿ��ֻ���ƶ�һ����ʹ��advance�����ƶ��ಽ

	temp.erase(temp.begin(), iter1);


	system("pause");

	return 0;
}