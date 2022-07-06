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

//class Derived : protected Base �� class Derived : public Base ���� ��ȯ
//����� protected�� �޴� �ٸ� base ���� ���ǵ� �Լ����� protected �ϰ� �Ǿ�
//�ܺ� main ���� ����ϱ� ��ư� �ȴ�.
//���� public(derived) - public(base) ���� ���� ������ ����.
