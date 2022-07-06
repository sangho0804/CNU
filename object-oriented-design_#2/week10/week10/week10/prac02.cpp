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
		Derived* yy = dynamic_cast<Derived*>(xx);
		yy->what();
		getchar();
		return 0;
	}

	//dynamic_cast 는 안전한지 아닌지를 compile 을 통해
	//check 할 수 있는 여지를 남겨놓는다. 따라서 downcast가 
	//발생하면 compile error 를 발생하게 된다. 
	//down casting 은 기본적으로 compile 에서 허용을 하지 않기 때문