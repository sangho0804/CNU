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

//시퀀스 컨테이너 vector
//터에는 원소들이 메모리 상에서 실제로 순차적으로 저장되어 있고, 따라서 임의의 위치에 있는 원소를 접근하는 것을 매우 빠르게 수행

// 컨테이너에 원소를 추가하거나 제거하게 되면 기존에 사용하였던 모든 반복자는 사용할 수 없게 된다.
//따라서 vec.erase(itr)을 수행하게 되면
//itr 은 더이상 유효한 반복자가 아니게 된다.
//이는 itr != vec.end() 가 계속 성립하게 되어 루프에 빠진다.
//따라서 itr 를 유효한 반복자로 다시 설정해주면 된다.