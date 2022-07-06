#include <iostream>
bool funcA() {
	int c;
	std::cin >> c;
	if (c < 10) //Let's assume this is exception
		//return false;
		throw std::out_of_range("Invalid input!!");

	return true;
}
int main() {
	try
	{
		funcA();
	}
	catch (std::out_of_range& e)
	{
		std::cout << "Exception : " << e.what() << std::endl;
	}
	while (1);
	
}
//예외는 out_of_range("Invalid Input!!")을 사용. 
// main 함수의 catch 문에서 "Invalid//Input"을 예외 인자로 받아 출력