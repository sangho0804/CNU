//����01
//�ǽ�04 �ڵ忡 ���۷����� �̿��Ͽ� �Լ� ����
#include <iostream>
void increment(int& x) //�ּҰ� ����
{
	++x;
}
int main()
{
	int x = 55;
	
	std::cout << " Before increment: " << x << std::endl;
	increment(x);
	std::cout << " After increment: " << x << std::endl;
	system("pause");
	return 0;
}

