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
	//static �� ��� �Լ� �̸��� ������ �Ķ���� ������ Ÿ���� �޶����� ���
	//run time �� � ���α׷��� ����Ǵ� ���߿� � Ÿ���� �������� ���� run time polymorphism
	// //� �ɹ��Լ��� virtual �Լ��� ���ǵǾ��ִٸ� rum time �������� ���ϼ� �ִ�.
	//�׷��� ������ ȣ��Ǵ°��� run time ���� dynamic �ϰ� �����ɼ� �ִ�. 
	//���α׷��� ����Ǵ� run time �� �Լ��� ȣ�� ����Ǵ� ���� �������� ������ �ȴ�.
	//���� dynamic cast�� compile �� ���� ���� chack �� �ϰ� �Ǵµ� 
	//��Ÿ�� ���� ������ ������� �ʴ´ٸ� �������� ���������ʰ� 
	//debeg error �� �߻��ϰ� �ȴ�.
	