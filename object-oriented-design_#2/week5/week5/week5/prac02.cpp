#include <iostream>
using namespace std;
int i;
class A
{
public:
	~A()
	{
		i = 10;
	}
};


int& foo()
{
	i = 3;
	A ob;
	return i;
}
int main()
{
	cout << foo() << endl;
	return 0;
}


//���۷����� �ޱ���
//foo() �Լ��� ��� 3�� ��ȯ �ϸ�
//�Ҹ��� A ��ü�� ���ÿ� ���� �ϱ� ������ 
//main ������ ��� 3�� ��ȯ�Ѵ�.
//���۷����� �޾��ָ�
//�Լ��� �ּڰ��� �������ֱ� ������
//���� return �� i �� ���ָ�
//main ������ foo() �Լ����� ��ȯ�� i �� �ּڰ��� ����
//10 �� ��ȯ
