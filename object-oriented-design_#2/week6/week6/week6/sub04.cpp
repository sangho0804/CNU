#include <iostream>
#include <stdexcept>
class Test {
public:
	Test(char id) : id_(id) {}
	~Test() {
		std::cout << "Destructor execution: "
			<< id_ << std::endl;
	}
private:
	char id_;
};
int funcB() {
	Test r('B');
	throw std::runtime_error("Exception from funcB!\n");
	std::cout << "Executed in B" << std::endl;
}
int funcA() {
	Test r('A');
	funcB();
	std::cout << "Executed in A" << std::endl;
	return 0;
}
int main() {
	try {
		funcA();
	}
	catch (std::exception& e) {
		std::cout << "Exception : " << e.what();
	}
}
//예외가 발생하지 않는다면 sub func 들이 호출이 되고
//해당 func 이 끝나면 자신을 호출한 상위 func 으로 이동하게 된다.
//예외가 발생한다면
//자신을 호출한 func 으로 복귀를 하는 것이 아니라
// exception handler 가 있는 위치로 jump
//정상적인 경우 return 주소를 통해 이동하지만
//아닌경우  exception handler 주소를 찾아서 이동
//이 프로그램의 경우
// funcA() 를 실행
// r('A')를 실행
// funcB()를 실행
//r('B') 에서 exception 이 발생하여 본 함수가 메모리에서 파괴되고
// r('A') 도 종료가 되며
//catch 로 이동된다.
