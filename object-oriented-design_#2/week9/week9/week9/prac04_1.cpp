#include <iostream>
#define _CRT_SECURE_NO_WARNINGS

class Parent {
	char* p;
public:
	 Parent() {
		p = new char[10];
		std::cout << "Parent Constructor invocation" << std::endl;
	}
	virtual ~Parent() {
		delete[] p;
		std::cout << "Parent Destructor invocation" << std::endl;
	}
};
class Child : public Parent {
	char* c;
public:
	Child() : Parent() {
		c = new char[10];
		std::cout << "Child Constructor invocation" << std::endl;
	}
	~Child() {
		delete[] c;
		std::cout << "Child Destructor invocation" << std::endl;
	}
};
int main() {
	std::cout << "--- Case1: Normal Child instantiation ---" << std::endl; {
		Child* c = new Child();
		delete c;
	}

	std::cout << "--- Case2: Parent pointer to Child ---" << std::endl; {
		Parent* p = new Child();
		delete p;
	}

	getchar();
}

//destructor 에 virtual function 을 사용하지 않았기때문에 오류가 발생한다.
//위와 같이 사용 하지 않았을 경우 base class 의 object 만 destructor 만 호출된다.
//따라서 destructor 를 갖는 base class 에 virtual 함수를 붙어준다.
