//과제01
//실습04 코드에 레퍼런스를 이용하여 함수 적용
#include <iostream>
void increment(int& x) //주소값 참조
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

