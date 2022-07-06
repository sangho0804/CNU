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
//operator<< 을 구현하시오
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

//oerator 구현
//<< 를 사용하는 연산자를 오버로딩
//이를 통해서 out << a 를 직접적으로 실행 할 수 있다.