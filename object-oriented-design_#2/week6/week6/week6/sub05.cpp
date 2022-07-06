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
//���ܴ� out_of_range("Invalid Input!!")�� ���. 
// main �Լ��� catch ������ "Invalid//Input"�� ���� ���ڷ� �޾� ���