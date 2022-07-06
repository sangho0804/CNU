#include <iostream>

template<typename T>
void swap(T& a, T& b)
{
	T Temp = a;
	a = b;
	b = Temp;
}



int main() {

	
	int a = 1;
	int b = 2;
	float c = 3.3;
	float d = 4.4;
	swap(a, b);
	swap(c, d);

	std::cout << "a: " << a << ", b: " << b << std::endl;
	std::cout << "c: " << c << ", d: " << d << std::endl;
	return 0;
}

//template �� �̿��� swap �Լ� 
//type T �� ����ϴ� ���� �ڹ��� generic �� ����ϴٰ� ��������.
// ���� � �ڷ����� ���� swap �� �����ϱ� ���� type T �� ����
// 2���� ���ڸ� �޾� swap �� �����Ѵ�.