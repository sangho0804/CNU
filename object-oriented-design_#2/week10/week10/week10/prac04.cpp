#include <iostream>
#include <string>
#include <cassert>
class Base {
	std::string s;
public:
	Base() : s("Base") {
		std::cout << "Base class constructor" << std::endl;
	}
	virtual void what() { std::cout << s << std::endl; }

}; class Derived : public Base {
	std::string s;
public:
	Derived() : s("Derived"), Base() {
		std::cout << "Derived class	constructor" << std::endl;
	}
	void what() { std::cout << s << std::endl; }
};
int main() {
	Base p;
	Derived c;
	std::cout << " === Pointer ===" << std::endl;
	Base* xx = &c;//OK.upcast
	Derived* yy = dynamic_cast<Derived*>(&p); // Base object를 Derivedclass로 다운 캐스팅 시도
	yy->what();
	getchar();
	return 0;
}

//rtti 실행시간에 타입정보를 식별
//dynamic cast는 run time 중 rtti 기술을 사용하여 실제 객체가 무엇인지 판단한다.
//이전 03 과제의 경우 xx 는 c 에 포인터를 이어줌으로서 실제 객체가 가리키는 것이
// derived 인것을 알수 있었지만 , p 객체의 경우 base 객체 그 자체이기 때문에
//down casting 을 허용하지 않는다.
//따라서 캐스팅이 실패 하면서 포인터로 type id 를 받았기 때문에 null 을 반환
 //추가로 포인터로 type id 를 받았다면 p 객체 역시 포인터 여야 한다.