//과제02
#include <iostream>
int main()
{
	//5 값을 갖는 변수 설정
	int a = 5;
	//5 값을 갖는 변수를 레퍼런스로 연결
	int& x = a;
	std::cout << x << std::endl;
}

