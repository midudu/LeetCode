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


	//insert����
	for (int i = 0; i < a.size(); ++i)
	{
		pair<set<int>::iterator, bool> receive = temp.insert(a[i]);

		if (!receive.second)
			cout << a[i] << "insertion failed" << endl;
		else
			cout << a[i] << "insertion succeeded" << endl;
	}
		
	cout << endl;

	//�������
	for (set<int>::iterator iter = temp.begin(); iter != temp.end(); iter++)
		cout << *iter << endl;

	cout << endl;

	//�������
	for (set<int>::reverse_iterator riter = temp.rbegin(); riter != temp.rend(); riter++)
		cout << *riter << endl;

	//����
	if ( temp.find(4) != temp.end() )
		cout << "find 4" << endl;
	
	

	//ɾ��
	temp.erase(temp.begin());

	temp.erase(5);

	set<int>::iterator iter2 = temp.begin();
	std::advance(iter2, 4);                //set��iteratorÿ��ֻ���ƶ�һ����ʹ��advance�����ƶ��ಽ

	temp.erase(temp.begin(), iter2);


	system("pause");

	return 0;
}