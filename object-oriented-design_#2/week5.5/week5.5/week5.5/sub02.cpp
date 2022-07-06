#include <iostream>
#include <cstring>

class My_cat {
	char* name;
	int weight;


public:
	My_cat();
	My_cat(const char* name);
	My_cat(const My_cat& cat);
	~My_cat();

	//eat 함수 선언하시오
	My_cat& eat(int food);
	void show_status() const;
};
//자신을 return 해준다.
//return *this;
My_cat& My_cat::eat(int food) {
	weight += food;
	return *this;
}


My_cat::My_cat() :name(NULL), weight(10) { }

My_cat::My_cat(const char* cat_name) : weight(10) {
	name = new char[strlen(cat_name) + 1];
	strcpy(name, cat_name);
}

My_cat::My_cat(const My_cat& cat) : weight(10) { //Copy constructor
	std::cout << "Copy constructor invocation ! " << std::endl;
	name = new char[strlen(cat.name) + 1];
	strcpy(name, cat.name);
}

My_cat::~My_cat() {		//Destructor
	if (name) delete[] name;
}

//eat 함수를 구현하세요.
void My_cat::show_status() const {
	std::cout << " Weight : " << weight << std::endl;
}
int main() {
	My_cat cat1("Nabi");	//Cat 1 생성
	cat1.show_status();

	cat1.eat(4);
	cat1.show_status();

	cat1.eat(4);
	cat1.show_status();

	cat1.eat(4).eat(5).eat(6); //hint: 이런 형태의 연산 지원을 위해서는 this 키워드와 레퍼런스 활용이 요구됨
	cat1.show_status();

	getchar();
	return 0;
}

//레버런스를 리턴하기 때문에 연속으로 호출이 가능
//동일한 객체를 넘겨주는게 아니고 임시곅체를 넘겨주기때문에 
//레퍼런스를 달지 않으면 원하는 값이 나오지 않는다.


