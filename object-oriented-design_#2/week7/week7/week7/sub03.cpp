#include <iostream>

class GlobalClass
{
private:
	int m_value;
	static GlobalClass* s_instance;

	GlobalClass(int v = 0)
	{
		m_value = v;
	}
public:
	int get_value()
	{
		return m_value;
	}
	void set_value(int v)
	{
		m_value = v;
	}
	static GlobalClass* instance()
	{
		/* 내용을 완성하시오*/
		if (s_instance == NULL) {
			s_instance = new GlobalClass();
		}
		else {
			return s_instance;
		}
	}
};

// Allocating and initializing GlobalClass's
// static data member.  The pointer is being
// allocated - not the object itself.
GlobalClass* GlobalClass::s_instance = 0;

void foo(void)
{
	GlobalClass::instance()->set_value(1);
	std::cout << "foo: global_ptr is " << GlobalClass::instance()->get_value() << '\n';
}

void bar(void)
{
	GlobalClass::instance()->set_value(2);
	std::cout << "bar: global_ptr is " << GlobalClass::instance()->get_value() << '\n';
}

int main()
{
	std::cout << "main: global_ptr is " << GlobalClass::instance()->get_value() << '\n';
	foo();
	bar();
}

//과제2 에 싱글톤 디자인 패턴을 적용한 코드 이다.
//싱글톤 디자인 패턴을 사용하여 하나의 객체를 이용하여 
//프로그램을 실행할 수 있게 된다.