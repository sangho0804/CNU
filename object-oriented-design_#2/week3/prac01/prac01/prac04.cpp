//�ǽ�04
//�ǽ�03 �ڵ忡 �����͸� �̿��Ͽ� �Լ� ����
#include <iostream>
void increment(int *x) //������ ����
{
	++*x; //������ ����
}
int main() //main
{
	int x = 55;
	std::cout << " Before increment: " << x << std::endl;
	increment(&x); //�ּҰ� ����
	std::cout << " After increment: " << x << std::endl;
	system("pause");
	return 0;
}

