#include <fstream>
#include <iostream>
#include <string>
class AnyString {
	std::string anyString;
public:
	AnyString(const std::string& anyString) : anyString(anyString) {}
	std::string getAnyString() {
		return "Stored String :: " + anyString;
	}
	friend std::ofstream& operator<<(std::ofstream& o, AnyString& a);
};
//operator<< �� �����Ͻÿ�
std::ofstream& operator<<(std::ofstream& o, AnyString& a) {
	o << a.anyString;
	return o;
}


int main() {
	std::ofstream out("testOveroding.txt");
	AnyString a("Hello, this is operator overloading test!!!-sub2");
	out << a << std::endl;
	return 0;
}

//oerator ����
//<< �� ����ϴ� �����ڸ� �����ε�
//�̸� ���ؼ� out << a �� ���������� ���� �� �� �ִ�.