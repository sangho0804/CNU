#include <iostream>
#include <vector>
#define _CRT_SECURE_NO_WARNINGS

int main() {
	std::vector<int> vec;
	vec.push_back(11);
	vec.push_back(22);
	vec.push_back(33);
	vec.push_back(44);
	// Remove an element from vector if its value is equal to 22
	for (std::vector<int>::iterator itr = vec.begin(); itr != vec.end(); ++itr) {
		if (*itr == 22) {
			vec.erase(itr);
			itr = vec.begin();

		}
	}

	// Print Entire vector contents after the removal of element
	for (std::vector<int>::iterator itr = vec.begin(); itr != vec.end();
		++itr) {
		std::cout << "Vector element: " << *itr << std::endl;
	}
	getchar();
}

//������ �����̳� vector
//�Ϳ��� ���ҵ��� �޸� �󿡼� ������ ���������� ����Ǿ� �ְ�, ���� ������ ��ġ�� �ִ� ���Ҹ� �����ϴ� ���� �ſ� ������ ����

// �����̳ʿ� ���Ҹ� �߰��ϰų� �����ϰ� �Ǹ� ������ ����Ͽ��� ��� �ݺ��ڴ� ����� �� ���� �ȴ�.
//���� vec.erase(itr)�� �����ϰ� �Ǹ�
//itr �� ���̻� ��ȿ�� �ݺ��ڰ� �ƴϰ� �ȴ�.
//�̴� itr != vec.end() �� ��� �����ϰ� �Ǿ� ������ ������.
//���� itr �� ��ȿ�� �ݺ��ڷ� �ٽ� �������ָ� �ȴ�.