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

//operator 함수를 보면 bass 객체 name 에 할당받은 a 객체의 name을 붙여주고
//본 함수를 return 하는 과정을 보인다.
// 이는 레퍼런스를 이용하여 주소값을 할당 받아
// 함수를 return 한다.
//또한 copy assign operator 형식
//dog 는 cat 을 붙여준 형식 그대로 진행되고
// cat 이 붙여진 dog 를 복사해서 catDog 가 된다.
//그리고 다시 dog name 을 호출 할때 
//catDog 형식으로 나타나게 된다.
