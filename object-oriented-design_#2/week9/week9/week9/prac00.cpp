#include <iostream>
//(operator overloading과 conversion에 대해 복습).

class MyData {
	int number;
	std::string strNumber;
public:
	MyData(int data, std::string str) : number(data), strNumber(str) {}
	//Operator conversion
	operator int() { return number; }
	operator std::string() { return strNumber; }
	//Unary operator
	int operator++(int) { //postfix operation (indicated by dummy 'int')
		int temp = number;
		number++;
		return temp;
	}
	int operator++() { //prefix operation
		return ++number;
	}
	friend std::ostream& operator<<(std::ostream&, MyData&);
};
// non-member operator<< function
std::ostream& operator<<(std::ostream& os, MyData& md) {
	return os << "This number is: " << md.strNumber << "\n";
}
int main() {
	MyData mydata(1, "one");
	//conversion operator 를 정의 해줬기때문에 객체가 들어갈 수 있다.
	std::string strNum = mydata;
	int intNum = mydata; 

	std::cout << strNum << std::endl; // one
	std::cout << intNum << std::endl; // 1
	std::cout << mydata++ << std::endl; // 1
	std::cout << ++mydata << std::endl; // 3
	std::cout << mydata;
}//비교 연산을 customizing 하여 재정의//본 프로그램은 ++ 연산을 member function 으로 정의 1개의 인자//본 프로그램은 << 연산을 nonmember function 으로 정의 2개의 인자//++ 연산은 int 를 넣어줌으로서 postfix라고 알려준다.//또한 인자를 받지 않은 것을 prefix 라고 알려준다.// 생성한 객체는 외부 함수에 접근하기 위해 friend 함수를 선언하여 overloading//보통은 객체를 cout 할 수 없지만 본 프로그램은//operator<< 를 구현 함으로서 객체만 작성해도 출력이 가능할 수 있다.//operator << (std::cout , md) 형태로 들어가게 된다. 이결과가 cout 에 들어간다.// class 가 또다른 타입으로 바꿀때 사용하기 위해 conversion operator 를 정의// member function 으로 정의//인자가 conversion이 일어나야 한다면 반드시 nonmember function 을 사용//main 문에서 int string type 에서 객체를 넣어 줬지만 conversion oprator 를 통해 가능하다.