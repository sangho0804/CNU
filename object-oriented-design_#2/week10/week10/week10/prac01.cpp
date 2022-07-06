#include <iostream>
#include <string>
#include <cassert>
class Base {
	std::string s;
public:
	Base() : s("Base") {
		std::cout << "Base class constructor" <<std::endl;
	}
	void what() { std::cout << s << std::endl; }
};
class Derived : public Base {
	std::string s;
public:
	Derived() : s("Derived"), Base() {
		std::cout << "Derived class	constructor" << std::endl; }
			
	void what() { std::cout << s << std::endl; }
	};
	int main() {
		Base p;
		Derived c;
		std::cout << " === Pointer ===" << std::endl;
		Base* xx = &c;//OK.upcast
		Derived* yy = static_cast<Derived*>(xx);
		yy->what();
		getchar();
		return 0;
	}

//drived type 의 객체 포인터 c를 base type 의 포인터 xx 에 이어줌으로서 upcast 가 가능
// base 객체 생성 , derived 객체 생성 derived 객체 생성에 s  인자와  base 객체를 선언 
//따라서 base 객체 , base 객체를 상속 받았기 때문에 base 객체 derived 객체 생성문 출력
//static cast keyword 는 명시적으로 개발자가 책임을 질테니 무조건 casting을 하겠다고 알려주는것
//yy 는 xx 를 통해 casting 을 하지만 앞에서 c 는 derived type 이고 xx 는 c를 가리키기 때문에
//결국 yy 는 같은 타입을 가리키게 된다. 
//downcast 를 했기때문에 yy 의 what 을 통해 s = drived 가 출력된다.