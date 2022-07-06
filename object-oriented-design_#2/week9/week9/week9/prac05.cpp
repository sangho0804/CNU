#include <iostream>
#include <vector>
// 도형
class Shape {
public:
	virtual void Draw() {
		std::cout << "Shape Draw" << std::endl;
	}
};
// 사각형
class Rect : public Shape {
public:
	// write code
	void Draw() {
		std::cout << "Rect Draw" << std::endl;
	}
};
// 원
class Circle : public Shape {
public:
	// write code
	void Draw() {
		std::cout << "Circle Draw" << std::endl;
	}
};
// 삼각형
class triangle : public Shape {
public:
	// write code
	void Draw() {
		std::cout << "triangle Draw" << std::endl;
	}
};
int main() {
	std::vector<Shape*> v1; // 도형 저장 버퍼
	v1.push_back(new Rect);
	v1.push_back(new Circle);
	v1.push_back(new triangle);
	for (int i = 0; i < v1.size(); i++)
		v1[i]->Draw();
}

//vector 배열을 이용하여 base class 를 타입으로 선언한 프로그램이다.
//Draw 함수를 virtual 함수로 정의하여 다형성을 형성 하였고, 
// 각각의 child class 에 draw 함수를 override 하여 각각의 오브젝트에 맞는
//print 문을 형성하였다.