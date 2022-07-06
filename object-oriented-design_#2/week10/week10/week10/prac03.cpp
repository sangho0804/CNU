#include <iostream>
#include <string>
#include <cassert>
class Base {
	std::string s;
public:
	Base() : s("Base") {
		std::cout << "Base class constructor" <<
			std::endl;
	}
	virtual void what() { std::cout << s << std::endl; }
};
class Derived : public Base {
	std::string s;
public:
	Derived() : s("Derived"), Base() {
		std::cout << "Derived class constructor" << std::endl; }
			void what() { std::cout << s << std::endl; }
	};
	int main() {
		Base p;
		Derived c;
		std::cout << " === Pointer ===" << std::endl;
		Base* xx = &c;//OK.upcast
		Derived* yy = dynamic_cast<Derived*>(xx);
		yy->what();
		getchar();
		return 0;
	}

	//run time polymorphism
	//static 의 경우 함수 이름이 같지만 파라미터 갯수나 타입이 달라지면 허용
	//run time 은 어떤 프로그램이 실행되는 도중에 어떤 타입이 정해지는 것을 run time polymorphism
	// //어떤 맴버함수가 virtual 함수로 정의되어있다면 rum time 다형성을 보일수 있다.
	//그래서 실제로 호출되는것은 run time 에서 dynamic 하게 결정될수 있다. 
	//프로그램이 실행되는 run time 에 함수를 호출 실행되는 도중 동적으로 결정이 된다.
	//따라서 dynamic cast는 compile 이 실행 도중 chack 를 하게 되는데 
	//런타임 형식 정보를 사용하지 않는다면 동적으로 결정되지않고 
	//debeg error 를 발생하게 된다.
	