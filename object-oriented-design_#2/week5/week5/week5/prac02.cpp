#include <iostream>
using namespace std;
int i;
class A
{
public:
	~A()
	{
		i = 10;
	}
};


int& foo()
{
	i = 3;
	A ob;
	return i;
}
int main()
{
	cout << foo() << endl;
	return 0;
}


//레퍼런스를 달기전
//foo() 함수가 상수 3을 반환 하며
//소멸자 A 객체를 동시에 실행 하기 때문에 
//main 에서는 상수 3을 반환한다.
//레퍼런스를 달아주면
//함수는 주솟값을 참조해주기 때문에
//실제 return 은 i 를 해주며
//main 에서는 foo() 함수에서 반환된 i 의 주솟값을 통해
//10 을 반환
