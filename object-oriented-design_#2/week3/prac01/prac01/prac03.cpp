//실습03
#include <iostream>
void increment(int x) //x ++
{
	++x;
}
int main() //main
{
	//int x = 55
	int x = 55;

	std::cout << " Before increment: " << x << std::endl;
	increment(x);
	std::cout << " After increment: " << x << std::endl;
	system("pause");
	return 0;
}

// x값은 5가 나온다.
