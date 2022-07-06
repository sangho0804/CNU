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
	swap<int>(a, b); //swap(a,b)�� ����
	swap<float>(c, d); //swap(c,d)�� ����
	swap(e, f);
	


	std::cout << "a: " << a << ", b: " << b << std::endl;
	std::cout << "c: " << c << ", d: " << d << std::endl;
	std::cout << "e: " << e << ", f: " << f << std::endl;
	return 0;
}
//swap<std::string>() �������� �����ϴ°��� �ȵȴ�.
// �������� �Լ��� 2�� �� ������ �ҷ����� �����Ϸ��� �˼� ���� ������ �߻��Ѵ�.
//�Լ� ���ø��� �κ� Ư��ȭ �Ұ��� �ϴ�.
// ���� �����ε����� �������� �ذ��Ѵ�.
//���ø��� Ư��ȭ�� �Ű������� ������ ����
//���������� Ư��ȭ�� �Ϲ������� �ش�
//�Լ� ���ø� ��ȯ���� ����
//��ȯ�� �տ� template<> �� ���δ�.
