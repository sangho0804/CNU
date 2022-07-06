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

//drived type �� ��ü ������ c�� base type �� ������ xx �� �̾������μ� upcast �� ����
// base ��ü ���� , derived ��ü ���� derived ��ü ������ s  ���ڿ�  base ��ü�� ���� 
//���� base ��ü , base ��ü�� ��� �޾ұ� ������ base ��ü derived ��ü ������ ���
//static cast keyword �� ��������� �����ڰ� å���� ���״� ������ casting�� �ϰڴٰ� �˷��ִ°�
//yy �� xx �� ���� casting �� ������ �տ��� c �� derived type �̰� xx �� c�� ����Ű�� ������
//�ᱹ yy �� ���� Ÿ���� ����Ű�� �ȴ�. 
//downcast �� �߱⶧���� yy �� what �� ���� s = drived �� ��µȴ�.