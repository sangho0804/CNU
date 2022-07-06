#include <iostream>
using namespace std;

template <typename T>
void fun(const T& x)
{
	static int count = 0;
	cout << "x = " << x << " count = " << count << endl;
	++count;
	return;
}
int main()
{
	fun<int>(1);
	cout << endl;
	fun<int>(1);
	cout << endl;
	fun<double>(1.1);
	cout << endl;
	return 0;
}
//컴파일러는 모든 데이터 유형에 대해 템플릿 함수의 새 인스턴스를 만든다. 
//따라서 컴파일러는 int double 두 개의 함수를 불러온다.
//모든 인스턴스에는 고유한 정적 변수 복사본이 존재한다. 
//function의 int 인스턴스는 두 번 호출되어 count가 증가