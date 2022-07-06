//실습04
//실습03 코드에 포인터를 이용하여 함수 적용
#include <iostream>
void increment(int *x) //포인터 설정
{
	++*x; //포인터 설정
}
int main() //main
{
	int x = 55;
	std::cout << " Before increment: " << x << std::endl;
	increment(&x); //주소값 참조
	std::cout << " After increment: " << x << std::endl;
	system("pause");
	return 0;
}

