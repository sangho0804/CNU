//����03
#include<iostream>
//�Լ� ���ڿ� ���� ���۷����� �ٿ��ش�.
//main ���� �Լ��� ���� ���� ���ڴ� �ش� �ּҸ� ���� 
//�Լ� ���� ������ ������ �� return

void swap(int &first, int &second)
{
	int temp = first;
	first = second;
	second = temp;
}
int main()
{
	int a = 2, b = 3;
	swap(a, b);
	std::cout << a << " " << b << std::endl;
	return 0;
}