//과제03
#include<iostream>
//함수 인자에 각각 레퍼런스를 붙여준다.
//main 에서 함수를 통해 들어온 인자는 해당 주소를 통해 
//함수 안의 과정을 실행한 후 return

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