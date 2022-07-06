#include <iostream>
#include <string>
#include <cassert>
class Base {
	std::string s;
public:
	Base() : s("Base") {
		std::cout << "Base class constructor" <<std::endl;
	}
	virtual void what() { std::cout << s << std::endl; }
};
class Derived : public Base {
	std::string s;
public:Derived() : s("Derived"), Base() {
	std::cout << "Derived class constructor" << std::endl; }
		void what() { std::cout << s << std::endl; }
};
	  int main() {
		  Base p;
		  Derived c;
		  std::cout << " === Pointer ===" << std::endl;
		  Base* xx = &c;//OK.upcast
		  Derived yy = dynamic_cast<Derived&>(p); // 잘못된 레퍼런스 캐스팅 Base를 Derived로 다운캐스팅 시도
			  yy.what();
		  getchar();
		  return 0;
	  }
	  //05 번 과제 역시 객체 p 는 base type 의 객체 이기 때문에  
	  //down casting 이 허용되지 않는다. 다만 04 번 과제와 다른 출력인 이유는
	  // 레퍼런스를 type id 로 받는 경우 캐스팅이 실패 했다면 bad cast exception 예외가 발생하기 때문에
	  //debug error 가 발생하게 된다. 
	  //추가로 레퍼런스로 type id 를 받았다면 p 객체 역시 레퍼런스여야 한다.
