#include <iostream>
#include <string>
#include <cstring>
class Shape {
public:
	virtual void Draw() {}
};

class RoundedRectangle : public Shape {
public:
	//Override
	void Draw() {
		std::cout << "Inside RoundedRectangle::draw() method." << std::endl;
	}
};

class RoundedSquare : public Shape {
public:
	//Override
	void Draw() {
		std::cout << "Inside RoundedSquare::draw() method." << std::endl;
	}
};

class  Rectangle : public Shape {
public:
	//Override
	void Draw() {
		std::cout << "Inside Rectangle::draw() method." << std::endl;
	}
};

class Square : public Shape {
public:
	//Override
	void Draw() {
		std::cout << "Inside Square::draw() method." << std::endl;
	}
};

class AbstractFactory {
public:
	virtual Shape* getShape(const std::string& shapeType) const = 0;
};

class ShapeFactory : public AbstractFactory {
public:
	Shape* getShape(const std::string& shapeType) const override {
		if (shapeType == "RECTANGLE") {
			return new Rectangle();
		}
		else if (shapeType == "SQUARE") {
			return new Square();
		}
		return NULL;
	}

};

class RoundedShapeFactory : public AbstractFactory {
public:
	Shape* getShape(const std::string& shapeType) const override {
		if (shapeType == "RECTANGLE") {
			return new RoundedRectangle();
		}
		else if (shapeType == "SQUARE") {
			return new RoundedSquare();
		}
		return NULL;
	}

};

class FactoryProducer {
public:
	static AbstractFactory* getFactory(bool rounded) {

		if (rounded) {
			return new RoundedShapeFactory();
		}
		else {
			return new ShapeFactory();
		}

	}

};

int main() {

	FactoryProducer* FactoryProducer;
	//get shape factory
	AbstractFactory* shapeFactory = FactoryProducer->getFactory(false);
	//get an object of Shape Rectangle
	Shape *shape1 = shapeFactory->getShape("RECTANGLE");
	//call draw method of Shape Rectangle
	shape1->Draw();
	//get an object of Shape Square 
	Shape *shape2 = shapeFactory->getShape("SQUARE");
	//call draw method of Shape Square
	shape2->Draw();
	//get shape factory
	AbstractFactory* shapeFactory1 = FactoryProducer->getFactory(true);
	//get an object of Shape Rectangle
	Shape *shape3 = shapeFactory1->getShape("RECTANGLE");
	//call draw method of Shape Rectangle
	shape3->Draw();
	//get an object of Shape Square 
	Shape *shape4 = shapeFactory1->getShape("SQUARE");
	//call draw method of Shape Square
	shape4->Draw();
}

//�߻� ���丮 ����
//�� ������ �ִ� ��ü���� ��°�� ��� ���丮 Ŭ������ �����, 
//�̵� ���丮�� ���ǿ� ���� �����ϵ��� �ٽ� ���丮�� ���� ��ü�� �����ϴ� ����

