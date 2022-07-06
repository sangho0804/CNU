#include <iostream>
#include <string>

class Animal {
private:
	std::string name;

public:
	Animal() {};
	Animal(std::string name) : name(name) {};

	void showName() {
		std::cout << "Name is " << name << std::endl;
	}
	//assign copy operator
	Animal& operator+(const Animal& a) {
		name += a.name;
		return *this;
	}
};

int main() {

	Animal cat("Nabi");
	cat.showName();
	Animal dog("Jindo");
	dog.showName();
	//dog.operator+(cat)
	Animal catDog = dog + cat;
	catDog.showName();
	dog.showName();
	getchar();

	return 0;
}

//operator �Լ��� ���� bass ��ü name �� �Ҵ���� a ��ü�� name�� �ٿ��ְ�
//�� �Լ��� return �ϴ� ������ ���δ�.
// �̴� ���۷����� �̿��Ͽ� �ּҰ��� �Ҵ� �޾�
// �Լ��� return �Ѵ�.
//���� copy assign operator ����
//dog �� cat �� �ٿ��� ���� �״�� ����ǰ�
// cat �� �ٿ��� dog �� �����ؼ� catDog �� �ȴ�.
//�׸��� �ٽ� dog name �� ȣ�� �Ҷ� 
//catDog �������� ��Ÿ���� �ȴ�.
