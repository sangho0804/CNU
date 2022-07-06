#include <iostream>
#include <string>
//operator oberloading
//+ 연산을 사용
//member function 을 이용
//binary type
//객체의 연산을 정의해주기위해 사용

class Animal {
private:
	std::string name;

public:
	Animal() {};
	Animal(std::string name) : name(name) {};

	void showName() {
		std::cout << "Name is " << name << std::endl;
	}

	//operator+ 추가하세요
	Animal operator+ (const Animal& animal) {
		return Animal(name + animal.name);
	}
};

int main() {

	Animal cat("Nabi");
	cat.showName();
	Animal dog("Jindo");
	dog.showName();

	Animal catDog = dog + cat; //개냥이 합성
	catDog.showName();

	dog.showName();

	getchar();

	return 0;
}
