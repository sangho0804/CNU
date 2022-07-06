#include <vector>
#include <string>
#include <iostream>
class Base1 {
public:
	Base1(int n) : vector_(n, 3) {
		std::cout << "base1 생성자" << '\n';
	}
	//.....
private:
	std::vector<char> vector_;
};
class Base2 {
public:
	Base2(int n) : vector_(n, 3) {
		std::cout << "base2 생성자" << '\n';
	}
	//.....

private:
	std::vector<char> vector_;
};
class Derived : public Base2, Base1 {
public:
	Derived(const std::string& str) : Base2(1024), Base1(512)
	{
		i = 0;
	}
	// ...
private:
	std::string str_;
	int i = 0;
};
int main() {
	Derived drv("1");
	return 0;
}//임의로 생성자를 호출 할때 객체의 이름을 출력하도록 print 문을 작성해 보았다.//base2 , base1 순서로 호출된다.//생성자는 상속 받은 순서대로 왼쪽에서 오른쪽으로 컴파일러는 코드를 읽는다.