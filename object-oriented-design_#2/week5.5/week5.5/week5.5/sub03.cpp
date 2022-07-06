#include <iostream>
#include <string>
//operator oberloading
//+ ������ ���
//member function �� �̿�
//binary type
//��ü�� ������ �������ֱ����� ���

class Animal {
private:
	std::string name;

public:
	Animal() {};
	Animal(std::string name) : name(name) {};

	void showName() {
		std::cout << "Name is " << name << std::endl;
	}

	//operator+ �߰��ϼ���
	Animal operator+ (const Animal& animal) {
		return Animal(name + animal.name);
	}
};

int main() {

	Animal cat("Nabi");
	cat.showName();
	Animal dog("Jindo");
	dog.showName();

	Animal catDog = dog + cat; //������ �ռ�
	catDog.showName();

	dog.showName();

	getchar();

	return 0;
}
