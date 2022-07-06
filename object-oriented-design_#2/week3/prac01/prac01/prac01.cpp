//실습01
#include <string>
#include <iostream>
//main
int main() {

	//string 변수 설정
	std::string s;

	//출력문 , <<std::endl 은 개행
	std::cout << "문자를 입력하세요(100자 이내)." << std::endl;
	
	//입력 받을 변수 s 를 설정
	std::cin >> s;

	//출력문 입력한 문자 s 를 출력
	std::cout << "입력된 문자는 " << s << "입니다." << std::endl;

	system("pause"); // keep terminal open

	return 0;
}
