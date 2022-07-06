#include <iostream>
#include <string.h>
#pragma warning(disable:4996)
class Animal {
public:
	char* name;
	int age;
	Animal(int age_, const char* name_) {
		age = age_;
		name = new char[strlen(name_) + 1];
		strcpy(name, name_);
	}
	Animal(Animal& a) { //���� ������
		age = a.age;
		name = new char[strlen(a.name)+1];
		strcpy(name, a.name);

	}
	void changeName(const char* newName) {
		strcpy(name, newName);
	}
	void printAnimal() {
		std::cout << "Name: " << name << " Age: "
			<< age << std::endl;
	}
};
int main() {
	Animal A(10, "Jenny"); //10�� Jenny ����
	Animal B = A; // 10�� Jenny�� A�� B���� ����
	A.age = 22; //A�� ���̸� 22��� �ٲ�
	//char* brown = "Brown";
	A.changeName("Brown"); //A�� �̸��� Brown���� �ٲ�
	A.printAnimal();
	B.printAnimal();
	return 0;
}

//Name : Brown Age : 22
//Name : Jenny Age : 10

//shallow copy �� �ϱ⶧���� ���ÿ� �Ѵ� �ٲ�� �ȴ�.
//�׷��⿡ char �迭�� ���� name �� ���� �� ������ ����
//deep copy �� ����

