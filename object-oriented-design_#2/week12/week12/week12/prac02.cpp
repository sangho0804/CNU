#include <iostream>


template<typename T>
void swap(T& a, T& b)
{
	T Temp = a;
	a = b;
	b = Temp;

}

//specialization
template<>
void swap<std::string>(std::string& a, std::string& b)
{
	
	std::string Temp = a;
	a = b;
	b = Temp;

}



int main() {


	int a = 1;
	int b = 2;
	float c = 3.3;
	float d = 4.4;
	std::string e = "World";
	std::string f = "Hello";
	swap<int>(a, b); //swap(a,b)도 가능
	swap<float>(c, d); //swap(c,d)도 가능
	swap(e, f);
	


	std::cout << "a: " << a << ", b: " << b << std::endl;
	std::cout << "c: " << c << ", d: " << d << std::endl;
	std::cout << "e: " << e << ", f: " << f << std::endl;
	return 0;
}
//swap<std::string>() 형식으로 선언하는것은 안된다.
// 그이유는 함수를 2개 중 무엇을 불러올지 컴파일러가 알수 없어 에러가 발생한다.
//함수 템플릿은 부분 특수화 불가능 하다.
// 따라서 오버로딩으로 형식으로 해결한다.
//템플릿의 특수화는 매개변수가 개수가 같고
//데이터형의 특수화는 일반형에만 해당
//함수 템플릿 반환형과 동일
//반환형 앞에 template<> 를 붙인다.
