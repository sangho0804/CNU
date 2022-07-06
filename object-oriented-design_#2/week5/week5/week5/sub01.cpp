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
int foo()
{
	{
		i = 3;
		A ob;
	}
	return i;
}

int main()

{
	cout << foo() << endl;
	return 0;
}

// 중첩 괄호를 벗어나면 그 안에있는 변수들이 소멸한다.
// 때문에 소멸자 A 함수를 통해 i 값을 10으로 변환
//중첩 괄호를 벗어나 10을 return


