#include <iostream>
using namespace std;
namespace ns {
	void display();
	class Test {
	public:
		void display();
	};
}
void ns::Test::display() { cout << "Test::display()\n"; }
void ns::display() { cout << "display()\n"; }
int main() {
	ns::Test obj;
	ns::display();
	obj.display();
	return 0;
}

//namespace 사용
//변수의 이름이 같아지는것을 방지하기 위해 사용
//namespace는 함수나 구조체 혹은 변수 이름 등의 소속을 정해준다.
//따라서 소속을 붙여주면 오류를 해결 할 수 있다.

