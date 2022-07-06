#include <iostream>
class Test {
public:
	int num1;
	int num2;
	//»ı¼ºÀÚ
	Test(int n1, int n2) {
		num1 = n1;
		num2 = n2;
	}

	void print() {
		std::cout << "num1 : " << num1 << std::endl;
		std::cout << "num2 : " << num2 << std::endl;
	}
};

int main() {
	Test a = Test(1, 3);
	a.print();
}