class Base {
public:
	void func_1() {};
protected:
	void func_2() {};
private:
	int x_;
};
class Derived : public Base {
public:
	void func_3() {
		func_1();
		func_2();
	}
};
int main() {
	Derived d;
	d.func_3();
	d.func_1();
}

//class Derived : protected Base 를 class Derived : public Base 으로 변환
//상속을 protected로 받는 다면 base 에서 정의된 함수들은 protected 하게 되어
//외부 main 에서 사용하기 어렵게 된다.
//따라서 public(derived) - public(base) 으로 접근 가능해 진다.
