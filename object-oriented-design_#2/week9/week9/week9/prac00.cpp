#include <iostream>
//(operator overloading�� conversion�� ���� ����).

class MyData {
	int number;
	std::string strNumber;
public:
	MyData(int data, std::string str) : number(data), strNumber(str) {}
	//Operator conversion
	operator int() { return number; }
	operator std::string() { return strNumber; }
	//Unary operator
	int operator++(int) { //postfix operation (indicated by dummy 'int')
		int temp = number;
		number++;
		return temp;
	}
	int operator++() { //prefix operation
		return ++number;
	}
	friend std::ostream& operator<<(std::ostream&, MyData&);
};
// non-member operator<< function
std::ostream& operator<<(std::ostream& os, MyData& md) {
	return os << "This number is: " << md.strNumber << "\n";
}
int main() {
	MyData mydata(1, "one");
	//conversion operator �� ���� ����⶧���� ��ü�� �� �� �ִ�.
	std::string strNum = mydata;
	int intNum = mydata; 

	std::cout << strNum << std::endl; // one
	std::cout << intNum << std::endl; // 1
	std::cout << mydata++ << std::endl; // 1
	std::cout << ++mydata << std::endl; // 3
	std::cout << mydata;
}//�� ������ customizing �Ͽ� ������//�� ���α׷��� ++ ������ member function ���� ���� 1���� ����//�� ���α׷��� << ������ nonmember function ���� ���� 2���� ����//++ ������ int �� �־������μ� postfix��� �˷��ش�.//���� ���ڸ� ���� ���� ���� prefix ��� �˷��ش�.// ������ ��ü�� �ܺ� �Լ��� �����ϱ� ���� friend �Լ��� �����Ͽ� overloading//������ ��ü�� cout �� �� ������ �� ���α׷���//operator<< �� ���� �����μ� ��ü�� �ۼ��ص� ����� ������ �� �ִ�.//operator << (std::cout , md) ���·� ���� �ȴ�. �̰���� cout �� ����.// class �� �Ǵٸ� Ÿ������ �ٲܶ� ����ϱ� ���� conversion operator �� ����// member function ���� ����//���ڰ� conversion�� �Ͼ�� �Ѵٸ� �ݵ�� nonmember function �� ���//main ������ int string type ���� ��ü�� �־� ������ conversion oprator �� ���� �����ϴ�.