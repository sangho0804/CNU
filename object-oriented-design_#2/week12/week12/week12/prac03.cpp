#include <iostream>
template<typename T>
T min(T x, T y) {
	return x < y ? x : y;
}
int main() {
	int x = 3;
	int y = 2;
	double d = 2.1;
	double e = 3.3;
	std::cout << "min(x,y): " << min(x, y) << ", min(d,e): " << min(d, e) << ",	min(d, x) : " << min<double>(d,x) << std::endl;
		return 0;
}

//return type 이 모호 하기 때문에 eroor 가 발생한다. 같은 타입으로 정의되어 있지 않기때문에
//명시적으로 double 혹은 int 로 지정하지 않으면 안된다.
