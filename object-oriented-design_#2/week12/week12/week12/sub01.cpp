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

//template 를 이용한 swap 함수 
//type T 를 사용하는 것이 자바의 generic 과 비슷하다고 느껴진다.
// 따라서 어떤 자료형을 쓰든 swap 을 진행하기 위해 type T 로 정의
// 2개의 인자를 받아 swap 을 진행한다.