//�ǽ�01
#include <string>
#include <iostream>
//main
int main() {

	//string ���� ����
	std::string s;

	//��¹� , <<std::endl �� ����
	std::cout << "���ڸ� �Է��ϼ���(100�� �̳�)." << std::endl;
	
	//�Է� ���� ���� s �� ����
	std::cin >> s;

	//��¹� �Է��� ���� s �� ���
	std::cout << "�Էµ� ���ڴ� " << s << "�Դϴ�." << std::endl;

	system("pause"); // keep terminal open

	return 0;
}
